package app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登录界面
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginUIServlet" })
public class LoginUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.write("<form action='"+request.getContextPath()+"/LoginServlet' method='post'>");
		out.write("用户名:<input type='text' name='userName'/><br/>");
		out.write("密码:<input type='password' name='userPwd'/><br/>");
		out.write("验证码：<input type='text' name='code'/><img src='"+request.getContextPath()+"/ImageServlet'><br/>");
		out.write("<input type='submit' value='登录'>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
