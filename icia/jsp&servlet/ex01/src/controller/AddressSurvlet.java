package controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDAO;
import model.AddressVO;

@WebServlet(value = {"/", "/list.json", "/list", "/read", "/insert", "/update", "/delete"})
public class AddressSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO addressDAO = new AddressDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		switch(request.getServletPath()) {
		case "/":
			RequestDispatcher dis = request.getRequestDispatcher("home.jsp");	//render와 같은 기능
			request.setAttribute("pageName", "about.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/list.json":
			out.println(addressDAO.list());
			
			break;
			
		case "/list":
			System.out.println("list...");
			dis = request.getRequestDispatcher("home.jsp");
			request.setAttribute("pageName", "list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/read":
			System.out.println("read...");
			int id = Integer.parseInt(request.getParameter("id"));
			AddressVO addressVO = addressDAO.read(id);
			request.setAttribute("addressVO",  addressVO);
			dis = request.getRequestDispatcher("home.jsp");
			request.setAttribute("pageName", "read.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/insert":
			System.out.println("insert...");
			dis = request.getRequestDispatcher("home.jsp");
			request.setAttribute("pageName", "insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/update":
			System.out.println("update...");
			dis = request.getRequestDispatcher("update.jsp");
			dis.forward(request, response);
			
			break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AddressVO addressVO = new AddressVO();
		addressVO.setName(request.getParameter("name"));
		addressVO.setTel(request.getParameter("tel"));
		addressVO.setAddress(request.getParameter("address"));
		switch(request.getServletPath()) {
		case "/insert":
			System.out.println("post insert...");
			System.out.println(addressVO.toString());
			addressDAO.insert(addressVO);
			response.sendRedirect("/list");	// 리스트 페이지로 이동
			
			break;
			
		case "/delete":
			int id = Integer.parseInt(request.getParameter("id"));
			addressDAO.delete(id);
			
			break;
			
		case "/update":
			id = Integer.parseInt(request.getParameter("id"));
			addressVO.setId(id);
			System.out.println(addressVO.toString());
			addressDAO.update(addressVO);
			response.sendRedirect("/list");
			
			break;
		}
	}
}
