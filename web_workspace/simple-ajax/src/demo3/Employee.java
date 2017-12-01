package demo3;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.NONE)
public class Employee {

	@XmlElement(name="emp_id")
	private int id;
	@XmlElement(name="first_name")
	private String firstName;
	@XmlElement(name="last_name")
	private String lastName;
	@XmlElement(name="job_id")
	private String jobId;
	@XmlElement(name="salary")
	private double salary;
	@XmlElement(name="hire_date")
	@XmlJavaTypeAdapter(DateXmlAdapter.class)
	private Date hireDate;
	
	public Employee() {}	
	
	public Employee(int id, String firstName, String lastName, String jobId, double salary, Date hireDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobId = jobId;
		this.salary = salary;
		this.hireDate = hireDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	/*@XmlElement(name="hire_date")
	public String getSimpleHireDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(hireDate);
	}
	*/

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jobId=" + jobId
				+ ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}
	
}
