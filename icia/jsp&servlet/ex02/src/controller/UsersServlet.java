package controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.*;

@WebServlet(value={"/users", "/users/read", "/users/insert", "/idcheck", "/users/delete", "/users/update", "/users/list.json"})
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
	UserVO userVO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/heml;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		UserVO userVO;
		JSONObject obj;
		String id;
		
		switch(request.getServletPath()) {
		case "/users":		//사용자목록
			request.setAttribute("pageName", "/users/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/users/read":
			request.setAttribute("vo", userDAO.read(request.getParameter("id")));
			request.setAttribute("pageName", "/users/read.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/users/insert":	//사용자등록
			request.setAttribute("pageName", "/users/insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/idcheck":	//아이디중복확인
			id = request.getParameter("id");
			userVO = userDAO.read(id);
			
			obj = new JSONObject();
			obj.put("id", userVO.getId());
			out.println(obj.toJSONString());
			
			break;
			
		case "/users/list.json":
			int page = Integer.parseInt(request.getParameter("page"));
			ArrayList<UserVO> array = userDAO.list(page);
			JSONArray jArray = new JSONArray();
			
			for(UserVO vo : array) {
				obj = new JSONObject();
				obj.put("id", vo.getId());
				obj.put("name", vo.getName());
				obj.put("password", vo.getPassword());
				jArray.add(obj);
			}
			JSONObject jObject = new JSONObject();
			jObject.put("array", jArray);
			jObject.put("count", userDAO.count());
			out.print(jObject);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		userVO = new UserVO();
		userVO.setId(request.getParameter("id"));
		userVO.setName(request.getParameter("name"));
		userVO.setPassword(request.getParameter("password"));
		
		switch(request.getServletPath()) {
		case "/users/insert":
			System.out.println(userVO.toString());
			userDAO.insert(userVO);
			response.sendRedirect("/users");
			
			break;
		
		case "/users/delete":
			String id = request.getParameter("id");
			
			String sel = request.getParameter("sel");
			String del = "";
			if(sel.equals("복구")) del = "0";
			else del = "1";
			
			userDAO.delete(id, del);
			
			break;
			
		case "/users/update":
			System.out.println(userVO.toString());
			userDAO.update(userVO);
			response.sendRedirect("/users");
			
			break;
		}
	}
}
