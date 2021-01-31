package entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Status;

@Entity
@Table(name = "Deliveries")
public class Delivery {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "planned_date")
	private LocalDateTime plannedDate;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(length = 120, name = "supplier")
	private String supplier;

	public Delivery() {
		super();
	}

	public Delivery(LocalDateTime plannedDate, Status status, String supplier) {
		super();
		this.plannedDate = plannedDate;
		this.status = status;
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", plannedDate=" + plannedDate + ", status=" + status + ", supplier=" + supplier
				+ "]";
	}

	public String[] toStringArray() {
		String[] s = new String[4];
		s[0]=String.valueOf(id);
		s[1]=String.valueOf(plannedDate);
		s[2]=status.name();
		s[3]=supplier;
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(LocalDateTime plannedDate) {
		this.plannedDate = plannedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
