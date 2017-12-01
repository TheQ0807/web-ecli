package vo;

import java.text.DecimalFormat;
import java.util.Date;

public class FileInfo {

	private int no;
	private String name;
	private long size;
	private Date createdate;
	private String summary;
	
	private static DecimalFormat df = new DecimalFormat("##,###");
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public String getShortName() {
		if (name == null){
			return null;
		}
		return name.substring(13);
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public String getSizeWithComma() {
		return df.format(size);
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "FileInfo [no=" + no + ", name=" + name + ", size=" + size + ", createdate=" + createdate + ", summary="
				+ summary + "]";
	}
	
	
	
	
	
}
