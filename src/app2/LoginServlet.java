package app2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//登录的逻辑处理
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//登录逻辑:任何人都能登录成功
		String userName=request.getParameter("userName");
		//将用户数据放到HttpSession中
		HttpSession session=request.getSession();
		session.setAttribute("loginInfo", userName);
		
		//验证验证码
		String code=request.getParameter("code");
		//从HttpSession中取出验证码
		String sCode=(String)session.getAttribute("sCode");
		if(!code.equals(sCode)) {
			response.setHeader("Refresh","2;url="+request.getContextPath()+"/LoginUIServlet");
			response.getWriter().write("验证码错误;2秒后跳回登录页面！");
			
			return;
		}
		
	    //转到主页
		response.setHeader("Refresh","2;url="+request.getContextPath()+"/IndexServlet");
		response.getWriter().write("登录成功！2秒后自动跳转到主页！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
