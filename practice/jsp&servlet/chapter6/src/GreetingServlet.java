import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/greeting", initParams=@WebInitParam(name="FILE_NAME", value="c:/data/greeting_lig.txt"))
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter logFile;
	
	public void init() throws ServletException {
		String fileName = getInitParameter("FILE_NAME");
		try {
			logFile = new PrintWriter(new FileWriter(fileName, true));
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String greeting = "æ»≥Á«œººø‰, " + name + "¥‘.";
		if(logFile != null) {
			Date now = new Date();
			logFile.printf("%TF %TT - %s %n", now, now, name);
		}
		out.println("<html>");
		out.println("<head><title>¿ŒªÁ«œ±‚</title></head>");
		out.println("<body>");
		out.println(greeting);
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		if(logFile != null) {
			logFile.close();
		}
	}
}
