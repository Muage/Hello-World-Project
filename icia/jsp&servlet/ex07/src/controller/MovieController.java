package controller;

import java.io.File;
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

import model.MovieDAO;
import model.MovieVO;
import model.NaverAPI;

@WebServlet(value = {"/movie/search", "/movie/search.json", "/movie/list", "/movie/register", "/movie/insert", "/movie/delete","/download"})
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDAO movieDAO = new MovieDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		case "/movie/search":
			request.setAttribute("pageName", "/movie/search.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/movie/search.json":
			String query = request.getParameter("query") == null ? "마블" : request.getParameter("query");
			int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
			
			String result = NaverAPI.search(query, page);
			out.println(result);
			
			break;
			
		case "/movie/list":
			page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
			
			int count = movieDAO.count();
			int last = count % 5 == 0 ? (count / 5) : (count / 5) + 1;
			
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			request.setAttribute("last", last);
			request.setAttribute("array", movieDAO.list(page));
			request.setAttribute("pageName", "/movie/list.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/movie/insert":
			request.setAttribute("pageName", "/movie/insert.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/movie/delete":
			int id = Integer.valueOf(request.getParameter("id"));
			String image = request.getParameter("image");
			
			movieDAO.delete(id);	// 테이블 데이터 삭제
			
			// 이미지 삭제
			try {
				File file = new File("c:/image/movie/" + image);
				file.delete();
			} catch(Exception e) {
				System.out.println("MovieController 이미지삭제 : " + e.toString());
			}
			
			break;
			
		case "/download":
			image = request.getParameter("image");
			System.out.println("파일이름: " + download(image));
//			download(image);
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MovieVO movieVO = new MovieVO();
		
		switch(request.getServletPath()) {
		case "/movie/register":
			movieVO.setTitle(request.getParameter("title"));
			String image = download(request.getParameter("image"));
			movieVO.setImage(image);
			movieVO.setActor(request.getParameter("actor"));
			movieVO.setDirector(request.getParameter("director"));
			movieVO.setLink(request.getParameter("link"));
			movieVO.setPubDate(request.getParameter("pubDate"));
			movieDAO.insert(movieVO);
			
			break;
			
		case "/movie/insert":
			MultipartRequest multi = new MultipartRequest(request, "c:/image/movie", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
			movieVO.setTitle(multi.getParameter("title"));
			movieVO.setImage(multi.getFilesystemName("image"));
			movieVO.setActor(multi.getParameter("actor"));
			movieVO.setDirector(multi.getParameter("director"));
			movieVO.setPubDate(multi.getParameter("pubDate"));
			movieDAO.insert(movieVO);
			response.sendRedirect("/movie/list");
			
			break;
		}
		
	}
	
	// 이미지 다운로드
	public String download(String image) {
		String file = "";
		try {
			InputStream input = null; 
			OutputStream output = null;
			file = image.substring(image.lastIndexOf("/") + 1);
			output = new FileOutputStream("c:/image/movie/" + file);
			URL url = new URL(image);
			input = url.openStream();
			
			int data;
			while((data = input.read()) != -1) {
				output.write(data);
			}
			
			input.close();
			output.close();
		} catch(Exception e) {
			System.out.println("download: " + e.toString());
		}
		return file;
	}
}