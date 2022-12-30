import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	String str1 = request.getParameter("num1");
    	String str2 = request.getParameter("num2");
    	int num1 = Integer.parseInt(str1);
    	int num2 = Integer.parseInt(str2);
    	int sum = num1 + num2;
    	out.println("<html>");
    	out.println("<head><title>µ¡¼À ÇÁ·Î±×·¥ - °á°ú È­¸é</title></head>");
    	out.println("<body>");
    	out.printf("%d + %d = %d", num1, num2, sum);
    	out.println("</body>");
    	out.println("</html>");
	}
}
