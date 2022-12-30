package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CouDAO;
import model.CouVO;
import model.SqlVO;

@WebServlet(value = {"/cou/list", "/cou/list.json", "/cou/read", "/cou/insert", "/cou/update"})
public class CouController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouDAO cdao = new CouDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
	      
	      switch(request.getServletPath()) {
	      
	      case "/cou/list":
	         request.setAttribute("pageName", "/cou/list.jsp");
	         dis.forward(request, response);
	         
	         break;
	         
	      case "/cou/list.json":
	          SqlVO svo = new SqlVO();
	          svo.setKey(request.getParameter("key"));
	          svo.setWord(request.getParameter("word"));
	          svo.setOrder(request.getParameter("order"));
	          svo.setDesc(request.getParameter("desc"));
	          svo.setPage(Integer.parseInt(request.getParameter("page")));
	          svo.setPer(Integer.parseInt(request.getParameter("per")));         
	          out.println(cdao.list(svo));
	          
	          break;
	          
	      case "/cou/read":
	    	  String lcode = request.getParameter("lcode");
	    	  request.setAttribute("vo", cdao.read(lcode));
	    	  request.setAttribute("pageName", "/cou/read.jsp");
	    	  dis.forward(request, response);
	         
	    	  break;
	    	  
	      case "/cou/insert":
	    	  request.setAttribute("code", cdao.getCode());
	    	  request.setAttribute("pageName", "/cou/insert.jsp");
	    	  dis.forward(request, response);
	    	  
	    	  break;
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CouVO couVO = new CouVO();
		couVO.setLcode(request.getParameter("lcode"));
		couVO.setLname(request.getParameter("lname"));
		couVO.setHours(Integer.valueOf(request.getParameter("hours")));
		couVO.setCapacity(Integer.valueOf(request.getParameter("capacity")));
		couVO.setRoom(request.getParameter("room"));
		
		switch(request.getServletPath()) {
		case "/cou/insert":
			couVO.setInstructor(request.getParameter("instructor"));
//			System.out.println(couVO.toString());
			cdao.insert(couVO);
			response.sendRedirect("/cou/list");
		  	  
		  	break;
		  	
		case "/cou/update":
	    	  System.out.println(couVO.toString());
	    	  cdao.update(couVO);
	    	  response.sendRedirect("/cou/list");
	    	  
	    	  break;
		}
		
	}

}
