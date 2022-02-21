package user;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.UserService;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	MultipartRequest multi = null;
	UserService service = new UserService();
	int fileMaxSize = 10 * 1024 * 1024;
	String savePath = request.getRealPath("/upload").replaceAll("\\\\", "/");
	//try {
		multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
	 /*}catch (Exception e) {
		request.getSession().setAttribute("messageType", "오류메시지");
		request.getSession().setAttribute("messageContent", "파일크기는 10MB를 넘을 수 없습니다");
		response.sendRedirect("index.jsp");
		return;
	}*/
	String userID = multi.getParameter("userID");
	HttpSession session = request.getSession();
	if(!userID.contentEquals((String) session.getAttribute("userID"))) {
		session.setAttribute("messageType", "오류메시지");
		session.setAttribute("messageContent", "접근할 수 없습니다.");
		response.sendRedirect("index.jsp");
		return;			
	}
	String fileName = "";
	File file = multi.getFile("userProfile");
	if(file != null) {
		String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
		if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")) {
			String prev = service.getUser(userID).getUserProfile();
			File prevFile = new File(savePath + "/" + prev);
			if(prevFile.exists()) {
				prevFile.delete();
			}
			fileName = file.getName();
		}else {
			if(file.exists()) {
				file.delete();
			}
			session.setAttribute("messageType", "오류메시지");
			session.setAttribute("messageContent", "이미지 파일만 업로드 가능합니다.");
			response.sendRedirect("profileUpdate.jsp");
			return;				
		}
	}
	HashMap<String, String> map = new HashMap<String, String>(); //map에 넣어 userid와 passwd 검사
	map.put("userID", userID);
	map.put("fileName", fileName);
	
	System.out.println("propropro"+userID+fileName);
	service.profile(map);
	session.setAttribute("messageType", "성공 메시지");
	session.setAttribute("messageContent", "성공적인 업데이트");
	response.sendRedirect("index.jsp");
	return;				
	}

}
