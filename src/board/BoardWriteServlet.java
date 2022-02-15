package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.BoardService;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/BoardWriteServlet")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MultipartRequest multi = null;
		int fileMaxSize = 10 * 1024 * 1024;
		String savePath = request.getRealPath("/upload").replaceAll("\\\\", "/");
		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
//			request.getSession().setAttribute("messageType", "오류메시지");
//			request.getSession().setAttribute("messageContent", "파일크기는 10MB를 넘을 수 없습니다");
//			response.sendRedirect("index.jsp");
//			return;
		}
	//	String userID = multi.getParameter("userID");
		HttpSession session = request.getSession();
//		if(!userID.contentEquals((String) session.getAttribute("userID"))) {
//			session.setAttribute("messageType", "오류메시지");
//			session.setAttribute("messageContent", "접근할 수 없습니다.");
//			response.sendRedirect("index.jsp");
//			return;			
//		}
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		System.out.println(boardTitle+"////"+boardContent);
		String boardFile= " ";
		String boardRealFile = " ";
		System.out.println(boardTitle+"////"+boardContent+"///"+"");
//		File file = multi.getFile("boardFile");
//		if(file != null) {
//			boardFile = multi.getOriginalFileName("boardFile");
//			boardRealFile = file.getName();
//		}
		BoardDTO boardDTO = new BoardDTO(boardTitle, boardContent, boardFile, boardRealFile);
		BoardService boardService = new BoardService();
		System.out.println("hi"+ boardDTO.getBoardTitle());
		int n = boardService.write(boardDTO);
		session.setAttribute("messageType", "성공 메시지");
		session.setAttribute("messageContent", "성공적으로 게시물이 작성 되었습니다.");
		response.sendRedirect("boardView.jsp");
		return;				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
