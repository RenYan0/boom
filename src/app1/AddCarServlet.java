package app1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//加入购物车
@WebServlet(asyncSupported = true, urlPatterns = { "/AddCarServlet" })
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取id
		String id=request.getParameter("id");
		//找到对应的书
		BookDB db=new BookDB();
		Book book=db.findById(id);
		//把书放到HttpSession中
		HttpSession session=request.getSession();
		//获取HttpSession中当前的数据 
		List<Book> books=(List<Book>)session.getAttribute("cart");
		//添加当前的商品到购物车
		if(books==null) {
			 books=new ArrayList<Book>();
		}
		//写回到HttpSession中
		books.add(book);
		
		//List<Book> books=new ArrayList<Book>();
		//books.add(book);
		
		session.setAttribute("cart", books);  //代表一个购物车  购物车里有很多商品
		response.getWriter().write(book.getBookName()+"已经成功添加到了购物车！");
		
		//手动更改JSESSION(cookie)的存活时间
		Cookie c=new Cookie("JSESSION",session.getId());
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
