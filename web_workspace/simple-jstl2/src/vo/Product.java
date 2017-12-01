package vo;

public class Product {

	private int no;
	private String name;
	private int price;
	private String maker;
	public Product(int no, String name, int price, String maker) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.maker = maker;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", maker=" + maker + "]";
	}
	
	
}
