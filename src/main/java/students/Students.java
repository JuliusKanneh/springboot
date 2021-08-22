package students;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	private String id;
	private String name;
	private String department;
	
	
	/**
	 * 
	 */
	public Students() {
		super();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 * @param name
	 * @param department
	 */
	public Students(String id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
