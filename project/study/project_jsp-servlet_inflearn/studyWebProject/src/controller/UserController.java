package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import model.UserDAO;
import model.UserVO;

@WebServlet(value = {"/user/login.json", "/user/login", "/user/logout", "/user/ownList.json", "/user/ownList", "/user/learning", "/user/finish"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
	UserVO userVO = new UserVO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		switch(request.getServletPath()) {
		case "/user/login.json":
			userVO = userDAO.login(request.getParameter("userid"));
			JSONObject obj = new JSONObject();
			obj.put("userid", userVO.getUserid());
			obj.put("userpassword", userVO.getUserpassword());
			obj.put("username", userVO.getUsername());
			out.println(obj);
			session.setAttribute("userid", userVO.getUserid());
			
			break;
			
		case "/user/login":
			request.setAttribute("pageName", "/user/login.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/user/logout":
			session.invalidate();
//			response.sendRedirect("/");
			response.sendRedirect("/user/ownList");
			
			break;
			
		case "/user/ownList.json":
			String userid = request.getParameter("userid");
			out.println(userDAO.list(userid));
			
//			System.out.println(userDAO.list(userid));
			
			break;
			
		case "/user/ownList":
			request.setAttribute("pageName", "/user/ownList.jsp");
			dis.forward(request, response);
			
			break;
			
		// »Æ¿Œ ø‰∏¡
//		case "/user/ownList.json":
//			SqlVO sqlVO = new SqlVO();
//			sqlVO.setKey(request.getParameter("key"));
//			sqlVO.setWord(request.getParameter("word"));
//			sqlVO.setOrder(request.getParameter("order"));
//			sqlVO.setDesc(request.getParameter("desc"));
//			sqlVO.setPage(Integer.valueOf(request.getParameter("page")));
//			sqlVO.setPer(Integer.valueOf(request.getParameter("per")));
//			
////			System.out.println(sqlVO.toString());
//			out.print(userDAO.list(sqlVO));
//			
//			break;
			
		case "/user/learning":
			request.setAttribute("pageName", "/user/learning.jsp");
			dis.forward(request, response);
			
			break;
		}
	}
}