package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	public Employee() {
		super();
	}

	public Employee(String name, String surname) {
		super();
		
		this.name = name;
		this.surname = surname;
	}

	@Column(length = 120, name = "name")
	private String name;
	
	@Column(length = 120, name = "surname")
	private String surname;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private List<Schedule> schedules;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	public String[] toStringArray() {
		String[] s = new String[3];
		s[0]=String.valueOf(id);
		s[1]=name;
		s[2]=surname;
		return s;
	}
	
	public void addSchedule(Schedule schedule) {
		
		
		if(schedules == null) {
			
			schedules = new ArrayList<>();
			}
		schedules.add(schedule);
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}
