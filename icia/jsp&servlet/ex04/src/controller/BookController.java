package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.BookDAO;
import model.BookVO;

@WebServlet(value = {"/book/search", "/book/insert", "/book/list", "/book/list.json"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bookDAO = new BookDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		
		case "/book/search":
			request.setAttribute("pageName", "/book/search.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/book/insert":
			break;
			
		case "/book/list":
			request.setAttribute("pageName", "/book/list.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/book/list.json":
			int page = Integer.parseInt(request.getParameter("page"));
			ArrayList<BookVO> array = bookDAO.list(page);
			JSONArray jArray = new JSONArray();
			for(BookVO vo : array) {
				JSONObject obj = new JSONObject();
				obj.put("id", vo.getId());
				obj.put("title", vo.getTitle());
				obj.put("price", vo.getPrice());
				obj.put("image", vo.getImage());
				obj.put("authors", vo.getAuthors());
				obj.put("wdate", vo.getWdate());
				obj.put("contents", vo.getContents());
				jArray.add(obj);
			}
			
			JSONObject jObj = new JSONObject();
			jObj.put("array", jArray);
			jObj.put("count", bookDAO.count());
			out.println(jObj);
			
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BookVO bookVO = new BookVO();
		bookVO.setTitle(request.getParameter("title"));
		bookVO.setContents(request.getParameter("contents"));
		bookVO.setImage(request.getParameter("image"));
		bookVO.setPublisher(request.getParameter("publisher"));
		bookVO.setAuthors(request.getParameter("authors"));
		bookVO.setIsbn(request.getParameter("isbn"));
		bookVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		switch(request.getServletPath()) {
		
		case "/book/insert":
//			System.out.println(bookVO.toString());
			bookDAO.insert(bookVO);
			
			break;
		}
	}
}
