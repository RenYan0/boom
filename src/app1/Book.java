package app1;
// È∂‘œÛ
public class Book {
	private String id;
	private String bookName;
	private String bookAuthor;
	private String remark;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public Book(String id, String bookName, String bookAuthor, String remark) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.remark = remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", remark=" + remark + "]";
	}
	


}
