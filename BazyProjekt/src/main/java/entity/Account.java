package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {

	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	@MapsId
	private Employee employee;
	
	public Employee getEmployeeId() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", password=" + password + "]";
	}



	@Column(name="login")
	private String login;

	@Column(name="password")
	private String password;

	public Account() {
		super();
	}

	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	
}
