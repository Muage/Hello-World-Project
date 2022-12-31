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

import model.SqlVO;
import model.UserEnrollmentsDAO;

@WebServlet(value = {"/learn.json", "/learn"})
public class UserEnrollmentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserEnrollmentsDAO userEnrollmentsDAO = new UserEnrollmentsDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/learn.json":
			SqlVO sqlVO = new SqlVO();
			sqlVO.setKey(request.getParameter("key"));
			sqlVO.setWord(request.getParameter("word"));
			sqlVO.setOrder(request.getParameter("order"));
			sqlVO.setDesc(request.getParameter("desc"));
			sqlVO.setPage(Integer.valueOf(request.getParameter("page")));
			sqlVO.setPer(Integer.valueOf(request.getParameter("per")));
			
//			System.out.println(sqlVO.toString());
			out.print(userEnrollmentsDAO.list(sqlVO));
			
			break;
			
		case "/learn":
			request.setAttribute("pageName", "/learn.jsp");
			dis.forward(request, response);
			
			break;
		}
	}
}
