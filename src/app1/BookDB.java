package app1;

import java.util.HashMap;
import java.util.Map;


//ģ������
public class BookDB {
    private static Map<String,Book> books=new HashMap<String,Book>();
    
    static {
    	books.put("1", new Book("1","����","A","skcns"));
    	books.put("2", new Book("2","�Ǻ�","B","sfjgns"));
    	books.put("3", new Book("3","���","C","vaskcns"));
    	books.put("4", new Book("4","����","D","erskcns"));
    }
    //��ѯ������Ʒ
    public Map<String,Book> findAll(){
    	return books;
    }
    //����id��ѯһ����
    public Book findById(String id) {
    	return books.get(id);
    }

}
