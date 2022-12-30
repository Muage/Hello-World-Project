import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server-info")
public class ServerInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	
	ServletContext context = getServletContext();
	
	String serverInfo = context.getServerInfo();
	
	int majorVersion = context.getMajorVersion();
	int minorVersion = context.getMinorVersion();
	
	out.println("<html>");
	out.println("<head><title>웹 서버의 정보</title></head>");
	out.println("<body>");
	out.printf("웹 서버의 종류: %s <br>", serverInfo);
	out.printf("지원하는 서블릿 버전: %d, %d <br>", majorVersion, minorVersion);
	out.println("</body>");
	out.println("</html>");
	}
}
