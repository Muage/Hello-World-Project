import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divider")
public class DividerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int result = num1 / num2;
		
		out.println("<html>");
		out.println("<head><title>³ª´°¼ÀÇÁ·Î±×·¥</title></head>");
		out.println("<body>");
		out.printf("%d / %d = %d", num1, num2, result);
		out.println("</body>");
		out.println("</html>");
	}
}
