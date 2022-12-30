package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderVO;
import model.PurDAO;
import model.PurVO;
import model.SqlVO;

@WebServlet(value = {"/order/list", "/order/list.json", "/order/read.json", "/update/status", "/pur/insert", "/order/insert"})
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PurDAO pdao = new PurDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/order/list":
			request.setAttribute("pageName", "/order/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/order/list.json":
			SqlVO svo = new SqlVO();
			svo.setKey(request.getParameter("key"));
			svo.setWord(request.getParameter("word"));
			svo.setOrder(request.getParameter("order"));
			svo.setDesc(request.getParameter("desc"));
			svo.setPage(Integer.valueOf(request.getParameter("page")));
			svo.setPer(Integer.valueOf(request.getParameter("per")));
			
//			System.out.println(svo.toString());
			out.println(pdao.list(svo));
			
			break;
			
		case "/order/read.json":
			out.println(pdao.read(request.getParameter("id")));
			
			break;
			
		case "/update/status":
			String id = request.getParameter("id");
			String status = request.getParameter("status");
			pdao.updateStatus(id, status);
			
			break;
			
		case "/pur/insert":
			PurVO vo = new PurVO();
			vo.setName(request.getParameter("name"));
			vo.setAddress(request.getParameter("address"));
			vo.setTel(request.getParameter("tel"));
			vo.setEmail(request.getParameter("email"));
			vo.setPayType(request.getParameter("payType"));
//			System.out.println(vo.toString());
			out.println(pdao.insert(vo));
			
			break;
			
		case "/order/insert":
			OrderVO ovo = new OrderVO();
			ovo.setOrder_id(request.getParameter("oid"));
			ovo.setProd_id(request.getParameter("pid"));
			ovo.setPrice(Integer.valueOf(request.getParameter("price")));
			ovo.setQnt(Integer.valueOf(request.getParameter("qnt")));
			pdao.insert(ovo);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
