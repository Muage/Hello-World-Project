import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("texp/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String food = (String)session.getAttribute("food");
		String animal = request.getParameter("animal");
		
		session.invalidate();	//���� ����
		
		out.println("<html>");
		out.println("<head><title>���� �׽�Ʈ</title></head>");
		out.println("<body>");
		out.println("<h3>���� �׽�Ʈ</h3>");
		out.printf("����� %s�� %s�� �����ϴ� �����Դϴ�.", food, animal);
		out.println("</body>");
		out.println("</html>");
	}
}
