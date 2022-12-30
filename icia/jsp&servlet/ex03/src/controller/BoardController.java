package controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;

import model.BBSDAO;
import model.BBSVO;

@WebServlet(value = {"/bbs/list", "/bbs/list.json", "/bbs/insert", "/bbs/read", "/bbs/update", "/bbs/delete"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BBSDAO bbsDAO = new BBSDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {			
		case "/bbs/list":
			request.setAttribute("pageName", "/bbs/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/bbs/list.json":
			int page = Integer.parseInt(request.getParameter("page"));
			String type = request.getParameter("type");
			String query = request.getParameter("query");
			
			ArrayList<BBSVO> array = bbsDAO.list(page, type, query);
			JSONArray jArray = new JSONArray();
			for(BBSVO vo : array) {
				JSONObject obj = new JSONObject();
				obj.put("no", vo.getNo());
				obj.put("title", vo.getTitle());
				obj.put("content", vo.getContent());
				obj.put("writer", vo.getWriter());
				obj.put("wdate", vo.getWdate());
				jArray.add(obj);
			}
			
			JSONObject jObject = new JSONObject();
			jObject.put("count", bbsDAO.count(type, query));
			jObject.put("array", jArray);
			
			out.println(jObject);
			
			break;
			
		case "/bbs/insert":
			request.setAttribute("pageName", "/bbs/insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/bbs/read":
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("vo", bbsDAO.read(no));
			request.setAttribute("pageName", "/bbs/read.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/bbs/update":
			no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("vo", bbsDAO.read(no));
			request.setAttribute("pageName", "/bbs/update.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/bbs/delete":
			no = Integer.parseInt(request.getParameter("no"));
			bbsDAO.delete(no);
			response.sendRedirect("/bbs/list");
			
			break;	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BBSVO bbsVO = new BBSVO();
		bbsVO.setTitle(request.getParameter("title"));
		bbsVO.setContent(request.getParameter("content"));
		bbsVO.setWriter("spider");
		
		switch(request.getServletPath()) {
		case "/bbs/insert":
			System.out.println(bbsVO.toString());
			bbsDAO.insert(bbsVO);
			response.sendRedirect("/bbs/list");
			
			break;
		
		case "/bbs/update":
			int no = Integer.parseInt(request.getParameter("no"));
			bbsVO.setNo(no);
			bbsDAO.update(bbsVO);
			response.sendRedirect("/bbs/list");
			
			break;
		}
	}
}
