package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;

/**
 * Servlet implementation class MemberUIServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userProfile = "none";
				/*request.getParameter("userProfile");*/
		
		UserDTO dto = 
				new UserDTO(userID, userPassword, userName, userAge, userGender, userEmail,userProfile);
		System.out.println("check"+userID+userPassword+userName+userAge+userGender+userEmail+userProfile);
		System.out.println(dto.getUserID());
		UserService service = new UserService();
		int n = service.register(dto);
		System.out.println(n);			
		
		
		
		HttpSession session = request.getSession();
		if(n>0) {request.setAttribute("mesg", "회원가입성공");};
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
