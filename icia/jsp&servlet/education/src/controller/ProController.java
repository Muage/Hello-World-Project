package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProDAO;
import model.ProVO;
import model.SqlVO;

@WebServlet(value = {"/pro/slist.json", "/pro/clist.json", "/pro/list", "/pro/list.json", "/pro/insert", "/pro/read", "/pro/update"})
public class ProController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProDAO proDAO = new ProDAO();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		switch(request.getServletPath()) {
		case "/pro/slist.json":
			String pcode = request.getParameter("pcode");

			out.println(proDAO.slist(pcode));
			
			break;
			
		case "/pro/clist.json":
			pcode = request.getParameter("pcode");

			out.println(proDAO.clist(pcode));
			
			break;
			
		case "/pro/list":
			request.setAttribute("pageName", "/pro/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/pro/list.json":
			SqlVO sqlVO = new SqlVO();
			sqlVO.setKey(request.getParameter("key"));
			sqlVO.setWord(request.getParameter("word"));
			sqlVO.setOrder(request.getParameter("order"));
			sqlVO.setDesc(request.getParameter("desc"));
			sqlVO.setPage(Integer.valueOf(request.getParameter("page")));
			sqlVO.setPer(Integer.valueOf(request.getParameter("per")));
			
			out.print(proDAO.list(sqlVO));
			
			break;
			
		case "/pro/insert":
			request.setAttribute("code", proDAO.getCode());
			request.setAttribute("now", sdf.format(new Date()));
			request.setAttribute("pageName", "/pro/insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/pro/read":
			pcode = request.getParameter("pcode");
			request.setAttribute("vo", proDAO.read(pcode));
			request.setAttribute("pageName", "/pro/read.jsp");
			dis.forward(request, response);
			
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProVO proVO = new ProVO();
		proVO.setPcode(request.getParameter("pcode"));
		proVO.setPname(request.getParameter("pname"));
		proVO.setDept(request.getParameter("dept"));
		proVO.setTitle(request.getParameter("title"));
		proVO.setHiredate(request.getParameter("hiredate"));
		int salary = request.getParameter("salary") == "" ? 0 : Integer.valueOf(request.getParameter("salary"));
		proVO.setSalary(salary);
		
		switch(request.getServletPath()) {
		case "/pro/insert":
			System.out.println(proVO.toString());
			proDAO.insert(proVO);
			response.sendRedirect("/pro/list");
			
			break;
			
		case "/pro/update":
			System.out.println(proVO.toString());
			proDAO.update(proVO);
			response.sendRedirect("/pro/list");
			
			break;
		}
	}

}
