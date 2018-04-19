package app2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//ע���߼�
@WebServlet(asyncSupported = true, urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		//session.invalidate();  ע��HttpSession����
		session.removeAttribute("loginInfo"); //ֻ��Ҫ��յ�¼ʱ��������ݼ���
		
		//ת����ҳ
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"/IndexServlet");
		response.getWriter().write("ע���ɹ���2�����ת����ҳ��");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
