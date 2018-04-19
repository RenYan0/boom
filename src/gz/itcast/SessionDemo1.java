package gz.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//演示HttpSession的执行原理
@WebServlet(asyncSupported = true, urlPatterns = { "/SessionDemo1" })
public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		// http://192.168.0.174:8080/HttpSession/SessionDemo1?name=eric
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		//保存到HttpSession中
		HttpSession session=request.getSession();
		//服务器会为这个session对象分配一个GUID(唯一字符串)
		//服务器会自动的把GUID作为cookie数据发送给浏览器
		System.out.println(session.getId());
		session.setAttribute("name",name);
		response.getWriter().write("放好了。<a href='"+request.getContextPath()+"/SessionDemo2'>看看有木有</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
