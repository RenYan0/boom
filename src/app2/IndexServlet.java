package app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//��ҳ
@WebServlet(asyncSupported = true, urlPatterns = { "/IndexServlet" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//��HttpSession������ȡ���û���¼������
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("loginInfo");
		
		//���userName��Ϊ��  ������Ѿ���¼
		if(userName!=null) {
			out.write("��ӭ����"+userName+",<a href='"+request.getContextPath()+"/LogoutServlet'>�˳�</a>");
		}else {	
			out.write("��ã�����<a href='"+request.getContextPath()+"/LoginUIServlet'>��¼</a>����ע��");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
