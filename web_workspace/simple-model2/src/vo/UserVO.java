package vo;

public class UserVO {

	private String name;
	private String email;
	private Car myCar;
	
	public UserVO(){}

	public UserVO(String name, String email, Car myCar) {
		super();
		this.name = name;
		this.email = email;
		this.myCar = myCar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getType(){
		return "멍청이";
	}

	
	public Car getMyCar() {
		return myCar;
	}

	public void setMyCar(Car myCar) {
		this.myCar = myCar;
	}

	@Override
	public String toString() {
		return "UserVO [name=" + name + ", email=" + email + ", myCar=" + myCar + "]";
	}
	
}
