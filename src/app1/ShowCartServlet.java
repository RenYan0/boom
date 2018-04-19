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
//�鿴���ﳵ
@WebServlet(asyncSupported = true, urlPatterns = { "/ShowCartServlet" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡHttpSession�еĹ��ﳵ����
		HttpSession session=request.getSession();
		List<Book> books=(List<Book>)session.getAttribute("cart");
		
		//��ʾ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("<h3>��ǰ���ﳵ��������Ʒ:</h3>");
		if(books!=null) {
			for(Book b:books) {
				out.write(b.getBookName()+"<br/>");
			}
		}else {
			out.write("<h3>��ǰ���ﳵ��û����Ʒ���ɷ�����ҳ����ӣ�</h3>");
			out.write("<a href='"+request.getContextPath()+"/ShowAllServlet'>������ҳ��</a>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
