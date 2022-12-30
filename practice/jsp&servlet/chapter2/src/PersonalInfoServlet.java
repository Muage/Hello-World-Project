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
			gender = "��";
		} else {
			gender = "��";
		}
		String iNotice = request.getParameter("iNotice");
		String cNotice = request.getParameter("cNotice");
		String dNotice = request.getParameter("dNotice");
		String job = request.getParameter("job");
		out.println("<html>");
		out.println("<head><title>���� ���� �Է� - ��� ȭ��</title></head>");
		out.println("<body>");
		out.println("<h2>���� ���� �Է�</h2>");
		out.printf("�̸�: %s <br>", name);
		out.printf("���̵�: %s <br>", id);
		out.printf("��ȣ: %s <br>", password);
		out.printf("����: %s <br>", gender);
		out.printf("���� ����: %s <br>", noticeToHangul(iNotice));
		out.printf("���� ����: %s <br>", noticeToHangul(cNotice));
		out.printf("��� Ȯ�� ����: %s <br>", noticeToHangul(dNotice));
		out.printf("����: %s <br>", job);
		out.println("</body>");
		out.println("</html>");
	}

	private String noticeToHangul(String notice) {
		if(notice == null) {
			return "���� ����";
		} else if(notice.equals("on")) {
			return "����";
		} else {
			return notice;
		}
	}
}
