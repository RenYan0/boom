package app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��¼����
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginUIServlet" })
public class LoginUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.write("<form action='"+request.getContextPath()+"/LoginServlet' method='post'>");
		out.write("�û���:<input type='text' name='userName'/><br/>");
		out.write("����:<input type='password' name='userPwd'/><br/>");
		out.write("��֤�룺<input type='text' name='code'/><img src='"+request.getContextPath()+"/ImageServlet'><br/>");
		out.write("<input type='submit' value='��¼'>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
