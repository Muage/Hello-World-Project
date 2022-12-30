package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.NaverAPI;
import model.ShopDAO;
import model.ShopVO;

@WebServlet(value = {"/shop/search", "/shop/search.json", "/download", "/shop/list", "/shop/insert", "/shop/register"})
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopDAO shopDAO = new ShopDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		case "/shop/search":
			request.setAttribute("pageName", "/shop/search.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/shop/search.json":
			String query = request.getParameter("query");
			int page = Integer.valueOf(request.getParameter("page"));
			out.println(NaverAPI.search(query, page));
			
			break;
			
		case "/download":
			String image = request.getParameter("url");
			
			download(image);
			
			break;
		
		case "/shop/list":
			page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
			int count = shopDAO.count();
			int last = count % 5 == 0 ? (count / 5) : (count / 5) + 1;
			
			request.setAttribute("last", last);
			request.setAttribute("count", shopDAO.count());
			request.setAttribute("page", page);
			request.setAttribute("array", shopDAO.list(page));
			request.setAttribute("pageName", "/shop/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/shop/insert":
			request.setAttribute("newId", shopDAO.newId());
			request.setAttribute("pageName", "/shop/insert.jsp");
			dis.forward(request, response);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ShopVO shopVO = new ShopVO();		
		
		switch(request.getServletPath()) {
		case "/shop/insert":	//상품검색 insert
			shopVO.setId(request.getParameter("id"));
			shopVO.setTitle(request.getParameter("title"));
			shopVO.setPrice(Integer.valueOf(request.getParameter("price")));
			shopVO.setBrand(request.getParameter("brand"));
			shopVO.setImage(download(request.getParameter("url")));
			System.out.println(shopVO.toString());
			shopDAO.insert(shopVO);
			
			break;
			
		case "/shop/register":	//상품등록 insert
			MultipartRequest multi = new MultipartRequest(request, "c:/image", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
			shopVO.setId(multi.getParameter("id"));
			shopVO.setTitle(multi.getParameter("title"));
			shopVO.setPrice(Integer.valueOf(multi.getParameter("price")));
			shopVO.setBrand(multi.getParameter("brand"));
			shopVO.setImage("/" + multi.getFilesystemName("image"));
			
			System.out.println(shopVO.toString());
			shopDAO.insert(shopVO);
			response.sendRedirect("/shop/list");
			
			break;
		}
	}
	
	public String download(String image) {
		String file = "";
		InputStream input = null;
		OutputStream output = null;
		
		try {
			URL url = new URL(image);
			input = url.openStream();
			file = image.substring(image.lastIndexOf("/"));
			output = new FileOutputStream("c:/image/" + file);
			while(true) {
				int data = input.read();
				if(data == -1) break;
				output.write(data);
			}
		} catch(Exception e) {
			System.out.println("다운로드: " + e.toString());
		}
		
		return file;
	}
}
