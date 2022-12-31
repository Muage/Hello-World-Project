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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.BoardDAO;
import model.BoardVO;

@WebServlet(value = {"/board/list.json", "/board/list"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDAO = new BoardDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/board/list.json":
			int page = Integer.valueOf(request.getParameter("page"));
			String type = request.getParameter("type");
			String query = request.getParameter("query");
			
			ArrayList<BoardVO> array = boardDAO.list(page, type, query);
			JSONArray jArray = new JSONArray();
			for(BoardVO boardVO : array) {
				JSONObject obj = new JSONObject();
				obj.put("id", boardVO.getId());
				obj.put("title", boardVO.getTitle());
				obj.put("content", boardVO.getContent());
				obj.put("userid", boardVO.getUserid());
				obj.put("fdate", boardVO.getWriteDate());
				jArray.add(obj);
			}
			
			JSONObject jObject = new JSONObject();
			jObject.put("count", boardDAO.count(type, query));
			jObject.put("array", jArray);
			
			out.println(jObject);
			
			break;
			
		case "/board/list":
			request.setAttribute("pageName", "/board/list.jsp");
			dis.forward(request, response);
			
			break;
		}
	}
}
