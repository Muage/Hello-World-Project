

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs-post")
public class BBSPostServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		out.println("<html>");
		out.println("<<head><title>게시판 글쓰기 - 결과 화면</title></head>");
		out.println("<body>");
		out.printf("이름: %s <br>", name);
		out.printf("제목: %s <br>", title);
		out.println("--------------------<br>");
		out.printf("<pre>%s</pre>", content);
		out.println("--------------------<br>");
		out.println("저장되었습니다.");
		out.println("</body>");
		out.println("</html>");
	}
}
