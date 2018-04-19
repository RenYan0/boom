package app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//查看购物车
@WebServlet(asyncSupported = true, urlPatterns = { "/ShowCartServlet" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取HttpSession中的购物车数据
		HttpSession session=request.getSession();
		List<Book> books=(List<Book>)session.getAttribute("cart");
		
		//显示数据
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("<h3>当前购物车有以下商品:</h3>");
		if(books!=null) {
			for(Book b:books) {
				out.write(b.getBookName()+"<br/>");
			}
		}else {
			out.write("<h3>当前购物车中没有商品，可返回主页面添加！</h3>");
			out.write("<a href='"+request.getContextPath()+"/ShowAllServlet'>返回主页面</a>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
