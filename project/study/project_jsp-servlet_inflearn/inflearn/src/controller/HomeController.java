package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;


@WebServlet(value={"/", "/rec/list.json", "/rec/read"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		PrintWriter out = response.getWriter();
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		DAO dao = new DAO();
		
		switch(request.getServletPath()){
		case "/":
			request.setAttribute("pageName", "main.jsp");
			dis.forward(request, response);
			break;
			
		case "/rec/list.json":
			int start=Integer.parseInt(request.getParameter("start"));
			out.println(dao.list(start));
			break;
			
		case "/rec/read":
			request.setAttribute("pageName", "read.jsp");
			request.setAttribute("vo", dao.read(request.getParameter("lecturecode")));
			dao.read("lecturecode");
			dis.forward(request, response);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
