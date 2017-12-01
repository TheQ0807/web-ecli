package vo;

import custom.annotation.Columm;
import custom.annotation.Table;

@Table(name="TB_USER", generated=true)
public class User {

	@Columm(name="USER_NO", type="NUMBER")
	private int no;
	@Columm(name="USER_NAME", type="VARCHAR2")
	private String name;
	@Columm(name="USER_EMAIL", type="VARCHAR2")
	private String eamil;
	@Columm(name="USER_Phond", type="VARCHAR2")
	private String phone;
	
	
	
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
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", eamil=" + eamil + ", phone=" + phone + "]";
	}
	
	
}
