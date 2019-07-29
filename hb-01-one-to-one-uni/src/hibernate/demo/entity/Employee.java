package hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //主键由数据库自动生成（主要是自动增长型） 
	@Column(name = "id")
	private int id;

	@Column(name="first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "company")
	private String company;

	public Employee() {
		
	}

	
	
	public Employee(String first_name, String last_name, String company) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.company = company;
	}



	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", company=" + company
				+ "]";
	}
	
}
