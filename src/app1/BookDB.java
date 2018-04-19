package app1;

import java.util.HashMap;
import java.util.Map;


//模拟数据
public class BookDB {
    private static Map<String,Book> books=new HashMap<String,Book>();
    
    static {
    	books.put("1", new Book("1","哈哈","A","skcns"));
    	books.put("2", new Book("2","呵呵","B","sfjgns"));
    	books.put("3", new Book("3","吼吼","C","vaskcns"));
    	books.put("4", new Book("4","昂昂","D","erskcns"));
    }
    //查询所有商品
    public Map<String,Book> findAll(){
    	return books;
    }
    //根据id查询一本书
    public Book findById(String id) {
    	return books.get(id);
    }

}
