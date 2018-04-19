package app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//首页
@WebServlet(asyncSupported = true, urlPatterns = { "/IndexServlet" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//从HttpSession对象中取出用户登录的数据
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("loginInfo");
		
		//如果userName不为空  则代表已经登录
		if(userName!=null) {
			out.write("欢迎回来"+userName+",<a href='"+request.getContextPath()+"/LogoutServlet'>退出</a>");
		}else {	
			out.write("你好，请先<a href='"+request.getContextPath()+"/LoginUIServlet'>登录</a>或者注册");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
