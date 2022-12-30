import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String food = request.getParameter("food");
		HttpSession session = request.getSession();
		session.setAttribute("food", food);
		out.println("<html>");
		out.println("<head><title>성격 테스트</title></head>");
		out.println("<body>");
		out.println("<h3>좋아하는 동물은?</h3>");
		out.println("<form action='result'>");
		out.println("<input type='text' name='animal'>");
		out.println("<input type='submit' value='확인'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}