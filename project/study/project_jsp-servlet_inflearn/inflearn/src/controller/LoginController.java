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

import model.LoginDAO;
import model.UsersVO;

@WebServlet(value = {"/login.json", "/login", "/logout"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO userDAO = new LoginDAO();
	UsersVO usersVO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		switch(request.getServletPath()) {
		case "/login.json":
			usersVO = userDAO.login(request.getParameter("userid"));
			JSONObject obj = new JSONObject();
			obj.put("userid", usersVO.getUserid());
			obj.put("userpassword", usersVO.getUserpassword());
			obj.put("username", usersVO.getUsername());
			out.println(obj);
			session.setAttribute("userid", usersVO.getUserid());
			
			break;
			
		case "/login":
			request.setAttribute("pageName", "/login.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/logout":
			session.invalidate();
			response.sendRedirect("/");
			
			break;
		}
	}
}