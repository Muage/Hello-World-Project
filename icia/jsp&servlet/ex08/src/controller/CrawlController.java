package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet(value = {"/crawl/cgv", "/crawl/cgv.json", "/crawl/naver/top.json", "/crawl/news", "/crawl/naver/news.json", "/crawl/webtoon","/crawl/naver/webtoon.json"})
public class CrawlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		case "/crawl/cgv":
			request.setAttribute("pageName", "/crawl/cgv.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/crawl/cgv.json":
			try {
				Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
				Elements es = doc.select(".sect-movie-chart ol li");
				JSONArray array = new JSONArray();
				
				for(Element e : es) {
					var title = e.select(".title").text();
					var image = e.select("img").attr("src");
					var date = e.select(".txt-info strong").text();
					var percent = e.select(".percent span").text();
					var link = e.select("a").attr("href");
					if(title != "") {
						JSONObject obj = new JSONObject();
						obj.put("title", title);
						obj.put("image", image);
						obj.put("date", date);
						obj.put("percent", percent);
						obj.put("link", "http://cgv.co.kr/" + link);
						array.add(obj);
					}
				}
				out.println(array);
			} catch(Exception e) {
				System.out.println("CrawlCont cgv.json: " + e.toString());
			}
			
			break;
			
		case "/crawl/news":
			request.setAttribute("pageName", "/crawl/news.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/crawl/naver/top.json":
			try {
				Document doc = Jsoup.connect("https://finance.naver.com/").get();
				Elements es = doc.select("#_topItems1 tr");
				JSONArray array = new JSONArray();
				for(Element e : es) {
					String title = e.select("a").text();
					String price = e.select("td").get(0).text();
					String rate = e.select("td").get(1).text();
					JSONObject obj = new JSONObject();
					obj.put("title", title);
					obj.put("price", price);
					obj.put("rate", rate);
					array.add(obj);
				}
				out.println(array);
			} catch(Exception e) {
				System.out.println("CrawlCont naver/top: " + e.toString());
			}
			
			break;
		case "/crawl/naver/news.json":
			try {
				Document doc = Jsoup.connect("https://finance.naver.com/news/mainnews.naver").get();
				Elements es = doc.select(".newsList li");
				JSONArray array = new JSONArray();
				for(Element e : es) {
					String title = e.select("a").text();
					String content = e.select(".articleSummary").text();
					String link = e.select("a").attr("href");
					String image = e.select("img").attr("src");
					
					JSONObject obj = new JSONObject();
					obj.put("title", title);
					obj.put("content", content);
					obj.put("link", link);
					obj.put("image", image);

					array.add(obj);
				}
				out.println(array);
			} catch(Exception e) {
				System.out.println("CrawlCont naver/news: " + e.toString());
			}
			
			break;
			
		case "/crawl/webtoon":
			request.setAttribute("pageName", "/crawl/webtoon.jsp");
			dis.forward(request, response);
			
			break;
			
		case "/crawl/naver/webtoon.json":
			try {
				Document doc = Jsoup.connect("https://comic.naver.com/index").get();
				Elements es = doc.select(".genreRecomList li");
				JSONArray array = new JSONArray();
				for(Element e : es) {
					String title = e.select(".genreRecomInfo .title").text();
					String user = e.select(".genreRecomInfo .user").text();
					String summary = e.select(".genreRecomInfo .summary").text();
					String image = e.select(".genreRecomImg img").attr("src");
					String link = e.select(".genreRecomInfo a").attr("href");
					
					JSONObject obj = new JSONObject();
					obj.put("title", title);
					obj.put("user", user);
					obj.put("summary", summary);
					obj.put("image", image);
					obj.put("link", link);

					array.add(obj);
				}
//				out.println(array);
				
				JSONObject object = new JSONObject();
				JSONArray arr1 = new JSONArray();
				JSONArray arr2 = new JSONArray();
				JSONArray arr3 = new JSONArray();
				for(int i = 0; i < array.size(); i++) {
					if(i/3 == 0) {
						arr1.add(array.get(i));
					} else if(i/3 == 1) {
						arr2.add(array.get(i));
					} else if(i/3 == 2){
						arr3.add(array.get(i));
					}
				}
				object.put("arr1", arr1);
				object.put("arr2", arr2);
				object.put("arr3", arr3);
				out.println(object);
				
			} catch(Exception e) {
				System.out.println("CrawlCont naver/news: " + e.toString());
			}
			
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}