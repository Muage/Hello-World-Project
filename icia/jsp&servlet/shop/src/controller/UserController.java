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

@WebServlet(value = {"/user/login.json", "/user/login", "/user/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/heml;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		switch(request.getServletPath()) {
		case "/user/login.json":
			UserVO vo = dao.login(request.getParameter("uid"));
			JSONObject obj = new JSONObject();
			obj.put("uid", vo.getUid());
			obj.put("pass", vo.getPass());
			obj.put("uname", vo.getUname());
			out.println(obj);
			session.setAttribute("uid", vo.getUid());
			
			break;
			
		case "/user/login":
			request.setAttribute("pageName", "/user/login.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/user/logout":
			session.invalidate();
			response.sendRedirect("/");
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}