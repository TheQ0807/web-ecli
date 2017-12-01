package vo;

public class Todo {
	
	private int no;
	private String title;
	private String dates;
	private String contents;
	private String completed;
	
	public Todo(){}

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

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", dates=" + dates + ", contents=" + contents + ", completed="
				+ completed + "]";
	}
	
	
}
