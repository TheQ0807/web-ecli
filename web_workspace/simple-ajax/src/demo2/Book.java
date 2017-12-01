package demo2;

public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private boolean discount;
	private String bookinfo;
	
	public Book(){}
	
	

	public Book(int no, String title, String author, String publisher, int price, boolean discount, String bookinfo) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.discount = discount;
		this.bookinfo = bookinfo;
	}

	

	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	

	public String getBookinfo() {
		return bookinfo;
	}



	public void setBookinfo(String bookinfo) {
		this.bookinfo = bookinfo;
	}



	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", price="
				+ price + ", discount=" + discount + ", bookinfo=" + bookinfo + "]";
	}



	

	
	
	
}
