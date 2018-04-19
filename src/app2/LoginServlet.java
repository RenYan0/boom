package app2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��¼���߼�����
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//��¼�߼�:�κ��˶��ܵ�¼�ɹ�
		String userName=request.getParameter("userName");
		//���û����ݷŵ�HttpSession��
		HttpSession session=request.getSession();
		session.setAttribute("loginInfo", userName);
		
		//��֤��֤��
		String code=request.getParameter("code");
		//��HttpSession��ȡ����֤��
		String sCode=(String)session.getAttribute("sCode");
		if(!code.equals(sCode)) {
			response.setHeader("Refresh","2;url="+request.getContextPath()+"/LoginUIServlet");
			response.getWriter().write("��֤�����;2������ص�¼ҳ�棡");
			
			return;
		}
		
	    //ת����ҳ
		response.setHeader("Refresh","2;url="+request.getContextPath()+"/IndexServlet");
		response.getWriter().write("��¼�ɹ���2����Զ���ת����ҳ��");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
