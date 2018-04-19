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
//���빺�ﳵ
@WebServlet(asyncSupported = true, urlPatterns = { "/AddCarServlet" })
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//��ȡid
		String id=request.getParameter("id");
		//�ҵ���Ӧ����
		BookDB db=new BookDB();
		Book book=db.findById(id);
		//����ŵ�HttpSession��
		HttpSession session=request.getSession();
		//��ȡHttpSession�е�ǰ������ 
		List<Book> books=(List<Book>)session.getAttribute("cart");
		//��ӵ�ǰ����Ʒ�����ﳵ
		if(books==null) {
			 books=new ArrayList<Book>();
		}
		//д�ص�HttpSession��
		books.add(book);
		
		//List<Book> books=new ArrayList<Book>();
		//books.add(book);
		
		session.setAttribute("cart", books);  //����һ�����ﳵ  ���ﳵ���кܶ���Ʒ
		response.getWriter().write(book.getBookName()+"�Ѿ��ɹ���ӵ��˹��ﳵ��");
		
		//�ֶ�����JSESSION(cookie)�Ĵ��ʱ��
		Cookie c=new Cookie("JSESSION",session.getId());
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
