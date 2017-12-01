package vo;

public class User {

	private String name;
	private String id;
	private String pwd;
	private String email;
	
	public User() {}
	
	public User(String name, String id, String pwd, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
	
	
}
