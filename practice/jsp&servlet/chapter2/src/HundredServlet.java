import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;

@WebServlet("/hundred")
public class HundredServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = 0;
		
		for(int cnt = 1; cnt < 101; cnt++) {
			total += cnt;
		}
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><title>Hundred Servlet</title></head>");
//		out.println("<body>");
//		out.printf("1 + 2 + 3 + ... + 100 = %d", total);
//		out.println("</body>");
//		out.println("</html>");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>1부터 100까지 더하는 서블릿</title></head>");
		out.println("<body>");
		out.printf("1부터 100까지의 합은 = %d", total);
		out.println("</body>");
		out.println("</html>");
	}
}
