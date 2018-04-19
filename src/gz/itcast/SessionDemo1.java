package gz.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��ʾHttpSession��ִ��ԭ��
@WebServlet(asyncSupported = true, urlPatterns = { "/SessionDemo1" })
public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		// http://192.168.0.174:8080/HttpSession/SessionDemo1?name=eric
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		//���浽HttpSession��
		HttpSession session=request.getSession();
		//��������Ϊ���session�������һ��GUID(Ψһ�ַ���)
		//���������Զ��İ�GUID��Ϊcookie���ݷ��͸������
		System.out.println(session.getId());
		session.setAttribute("name",name);
		response.getWriter().write("�ź��ˡ�<a href='"+request.getContextPath()+"/SessionDemo2'>������ľ��</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
