package entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import enums.ContractType;
import enums.Position;



@Entity
@Table(name = "Contracts")
public class Contract {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "beginning")
	private LocalDate beginning;
	
	@Column(name = "ending")
	private LocalDate ending;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ContractType type;

	@Column(name ="salary")
	private int salary;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="position")
	private Position position;

	public Contract(LocalDate beginning, LocalDate ending, ContractType type, int salary,
			Position position) {
		super();
		
		this.beginning = beginning;
		this.ending = ending;
		this.type = type;
		this.salary = salary;
		this.position = position;
	}

	
	@Override
	public String toString() {
		return "Contract [id=" + id + ", beginning=" + beginning + ", ending=" + ending + ", type=" + type + ", salary="
				+ salary + ", position=" + position + "]";
	}

	public Contract() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getBeginning() {
		return beginning;
	}

	public void setBeginning(LocalDate beginning) {
		this.beginning = beginning;
	}

	public LocalDate getEnding() {
		return ending;
	}

	public void setEnding(LocalDate ending) {
		this.ending = ending;
	}

	public ContractType getType() {
		return type;
	}

	public void setType(ContractType type) {
		this.type = type;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
