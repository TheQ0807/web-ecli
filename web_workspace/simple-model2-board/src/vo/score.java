package vo;

import java.sql.Date;

public class score {

	private int no;
	private String name;
	private int ban;
	private int kor;
	private int eng;
	private int math;
	private int sci;
	private int his;
	private Date sysdate;
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
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getHis() {
		return his;
	}
	public void setHis(int his) {
		this.his = his;
	}
	public Date getSysdate() {
		return sysdate;
	}
	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}
	@Override
	public String toString() {
		return "score [no=" + no + ", name=" + name + ", ban=" + ban + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", sci=" + sci + ", his=" + his + ", sysdate=" + sysdate + "]";
	}
	
	
}
