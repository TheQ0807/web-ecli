package vo;

public class User {

	private String name;
	private String id;
	private String pwd;
	private String role;
	
	public User() {}
	
	
	
	public User(String name, String id, String pwd, String role) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", pwd=" + pwd + ", role=" + role + "]";
	}
	
	
}
