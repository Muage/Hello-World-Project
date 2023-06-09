package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ProDAO;
import model.ProVO;
import model.SqlVO;

@WebServlet(value = {"/pro/list.json", "/pro/list", "/pro/insert", "/pro/read", "/pro/update", "/pro/info"})
public class ProController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProDAO dao = new ProDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/pro/list.json":
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
			
		case "/pro/list":
			request.setAttribute("pageName", "/pro/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/pro/insert":
			request.setAttribute("code", dao.getCode());
			request.setAttribute("pageName", "/pro/insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/pro/read":
			request.setAttribute("vo", dao.read(request.getParameter("prod_id")));
			request.setAttribute("pageName", "/pro/read.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/pro/info":
			request.setAttribute("vo", dao.read(request.getParameter("prod_id")));
			request.setAttribute("pageName", "/pro/info.jsp");
			dis.forward(request, response);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 파일업로드
		MultipartRequest mul = new MultipartRequest(request, "c:/image/shop", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		// 데이터저장
		ProVO vo = new ProVO();
		vo.setProd_id(mul.getParameter("prod_id"));
		vo.setProd_name(mul.getParameter("prod_name"));
		vo.setCompany(mul.getParameter("company"));
		vo.setMall_id(mul.getParameter("mall_id"));
		vo.setDetail(mul.getParameter("detail"));
		vo.setPrice1(Integer.valueOf(mul.getParameter("price1")));
		vo.setPrice2(Integer.valueOf(mul.getParameter("price2")));
		vo.setImage(mul.getFilesystemName("image"));
		
		switch(request.getServletPath()) {
		case "/pro/insert":
			dao.insert(vo);
			response.sendRedirect("/pro/list");
			
			break;
			
		case "/pro/update":
			vo.setProd_del(mul.getParameter("prod_del"));
			if(vo.getImage() == null) {
				vo.setImage(mul.getParameter("oldImage"));
			}
			dao.update(vo);
//			System.out.println(vo.toString());
			response.sendRedirect("/pro/list");
			
			break;
		}
	}
}
