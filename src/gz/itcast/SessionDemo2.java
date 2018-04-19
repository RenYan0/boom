package gz.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��ʾHttpSession��ִ��ԭ��
@WebServlet(asyncSupported = true, urlPatterns = { "/SessionDemo2" })
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��HttpSession������ȡ������
		//�������Զ��Ĵ�cookie��ȡ��GUID
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		String name=(String)session.getAttribute("name");
		response.getWriter().write(name);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
