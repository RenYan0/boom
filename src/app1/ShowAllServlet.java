package app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�鿴������Ʒ
@WebServlet(asyncSupported = true, urlPatterns = { "/ShowAllServlet" })
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDB db = new BookDB();
		Map<String, Book> books = db.findAll();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.write("<h3>���������º��飺</h3>");
		for (Entry<String, Book> entry : books.entrySet()) {
			out.write(entry.getValue().getBookName() + "<a href='"+request.getContextPath()+"/AddCarServlet?id="+entry.getKey()+"'>���빺�ﳵ</a><br/>");
		}
		
		
		out.write("<a href='"+request.getContextPath()+"/ShowCartServlet'>�鿴���ﳵ</a>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
