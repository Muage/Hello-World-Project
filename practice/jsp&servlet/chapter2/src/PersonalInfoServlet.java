import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pinfo-result")
public class PersonalInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		if(gender.equals("male")) {
			gender = "남";
		} else {
			gender = "여";
		}
		String iNotice = request.getParameter("iNotice");
		String cNotice = request.getParameter("cNotice");
		String dNotice = request.getParameter("dNotice");
		String job = request.getParameter("job");
		out.println("<html>");
		out.println("<head><title>개인 정보 입력 - 결과 화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인 정보 입력</h2>");
		out.printf("이름: %s <br>", name);
		out.printf("아이디: %s <br>", id);
		out.printf("암호: %s <br>", password);
		out.printf("성별: %s <br>", gender);
		out.printf("공지 메일: %s <br>", noticeToHangul(iNotice));
		out.printf("광고 메일: %s <br>", noticeToHangul(cNotice));
		out.printf("배송 확인 메일: %s <br>", noticeToHangul(dNotice));
		out.printf("직업: %s <br>", job);
		out.println("</body>");
		out.println("</html>");
	}

	private String noticeToHangul(String notice) {
		if(notice == null) {
			return "받지 않음";
		} else if(notice.equals("on")) {
			return "받음";
		} else {
			return notice;
		}
	}
}
