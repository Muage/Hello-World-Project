package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SqlVO;
import model.StuDAO;
import model.StuVO;


@WebServlet(value={"/stu/list", "/stu/list.json", "/stu/insert", "/stu/read", "/stu/update"})
public class StuController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   StuDAO sdao = new StuDAO();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
      
      switch(request.getServletPath()) {
      
      case "/stu/list":
         request.setAttribute("pageName", "/stu/list.jsp");
         dis.forward(request, response);
         
         break;
         
      case "/stu/list.json":
          SqlVO svo = new SqlVO();
          svo.setKey(request.getParameter("key"));
          svo.setWord(request.getParameter("word"));
          svo.setOrder(request.getParameter("order"));
          svo.setDesc(request.getParameter("desc"));
          svo.setPage(Integer.parseInt(request.getParameter("page")));
          svo.setPer(Integer.parseInt(request.getParameter("per")));         
          out.println(sdao.list(svo));
          
          break;
          
      case "/stu/insert":
    	  request.setAttribute("code", sdao.getCode());
          request.setAttribute("pageName", "/stu/insert.jsp");
          dis.forward(request, response);
          
          break;
          
      case "/stu/read":
    	  String scode = request.getParameter("scode");
    	  request.setAttribute("vo", sdao.read(scode));
          request.setAttribute("pageName", "/stu/read.jsp");
          dis.forward(request, response);
          break;
      }  
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      StuVO stuVO = new StuVO();
	  stuVO.setScode(request.getParameter("scode"));
	  stuVO.setSname(request.getParameter("sname"));
	  stuVO.setAdvisor(request.getParameter("advisor"));
	  stuVO.setBirthday(request.getParameter("birthday"));
	  stuVO.setYear(request.getParameter("year"));
	  
      switch(request.getServletPath()) {
      case "/stu/insert":
    	  stuVO.setDept(request.getParameter("dept"));
//    	  System.out.println(stuVO.toString());
    	  sdao.insert(stuVO);
    	  response.sendRedirect("/stu/list");
    	  
    	  break;
    	  
      case "/stu/update":
    	  System.out.println(stuVO.toString());
    	  sdao.update(stuVO);
    	  response.sendRedirect("/stu/list");
    	  
    	  break;
      }
   }
}