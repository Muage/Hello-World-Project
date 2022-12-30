package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LocalDAO;
import model.LocalVO;

@WebServlet(value = {"/local/search", "/local/list", "/local/list.json", "/local/insert"})
public class LocalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocalDAO localDAO = new LocalDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
			case "/local/search":
				request.setAttribute("pageName", "/local/search.jsp");
				dis.forward(request, response);
				
				break;
				
			case "/local/list":
				int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
				int count = localDAO.count();
				int last = count % 7 == 0 ? count / 7 : (count / 7) + 1;
//				double last = Math.ceil(count / 7);
				
				request.setAttribute("page", page);
				request.setAttribute("last", last);
				request.setAttribute("array", localDAO.list(page));
				request.setAttribute("count", localDAO.count());
				request.setAttribute("pageName", "/local/list.jsp");
				dis.forward(request, response);
				
				break;
				
			case "/local/list.json":
				break;
				
			case "/local/insert":
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LocalVO localVO = new LocalVO();
		
		localVO.setId(request.getParameter("id"));
		localVO.setName(request.getParameter("name"));
		localVO.setPhone(request.getParameter("phone"));
		localVO.setKeyword(request.getParameter("keyword"));
		localVO.setAddress(request.getParameter("address"));
		localVO.setX(Double.valueOf(request.getParameter("x")));
		localVO.setY(Double.valueOf(request.getParameter("y")));
		
		switch(request.getServletPath()) {
		case "/local/insert":
			//System.out.println(localVO.toString());
			localDAO.insert(localVO);
			break;
			
		}
	}
}
