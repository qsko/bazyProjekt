package entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "beginning")
	private LocalDateTime beginning;
	
	@Column(name = "ending")
	private LocalDateTime ending;

	public Schedule() {
		super();
	}

	public Schedule(LocalDateTime beginning, LocalDateTime ending) {
		super();
		this.beginning = beginning;
		this.ending = ending;
	}


	@Override
	public String toString() {
		return "Schedule [id=" + id + ", beginning=" + beginning + ", ending=" + ending + "]";
	}
	
	public String[] toStringArray() {
		String[] s = new String[4];
		s[0]=String.valueOf(id);
		s[1]=String.valueOf(employee.getId());
		s[2]=String.valueOf(beginning);
		s[3]=String.valueOf(ending);
		return s;
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

	public void setEmployee_id(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getBeginning() {
		return beginning;
	}

	public void setBeginning(LocalDateTime beginning) {
		this.beginning = beginning;
	}

	public LocalDateTime getEnding() {
		return ending;
	}

	public void setEnding(LocalDateTime ending) {
		this.ending = ending;
	}
	

	
}
