import java.io.*;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fibonacci", loadOnStartup=1)
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BigInteger arr[];
	
	@Override
	public void init() throws ServletException {
		arr = new BigInteger[100];
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("2");
		for(int cnt = 2; cnt < arr.length; cnt++) {
			arr[cnt] = arr[cnt - 2].add(arr[cnt - 1]);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("num");
		int num = Integer.parseInt(str);
		if(num > 100) {
			num = 100;
		}
		out.println("<html>");
		out.println("<head><title>피보나치 수열</title></head>");
		out.println("<body>");
		for(int cnt = 0; cnt < num; cnt++) {
			out.println(arr[cnt] + " ");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
