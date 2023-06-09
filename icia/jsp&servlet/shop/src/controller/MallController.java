package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MallDAO;
import model.SqlVO;

@WebServlet(value = {"/mall/list.json", "/mall/list"})
public class MallController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MallDAO dao = new MallDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/mall/list.json":
			SqlVO svo = new SqlVO();
			svo.setKey(request.getParameter("key"));
			svo.setWord(request.getParameter("word"));
			svo.setOrder(request.getParameter("order"));
			svo.setDesc(request.getParameter("desc"));
			svo.setPage(Integer.valueOf(request.getParameter("page")));
			svo.setPer(Integer.valueOf(request.getParameter("per")));
			
//			System.out.println(svo.toString());
			out.println(dao.list(svo));
			
			break;
			
		case "/mall/list":
			request.setAttribute("pageName", "/mall/list.jsp");
			dis.forward(request, response);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
