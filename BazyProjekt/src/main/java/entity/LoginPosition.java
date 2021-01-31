package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Position;

@Entity
@Table(name = "LoginPosition")
public class LoginPosition {
	@Id
	private int id;
	
	@Column(name = "login")
	private String login;

	@Enumerated(EnumType.STRING)
	@Column(name = "position")
	private Position position;
	
	public LoginPosition() {
		super();
	}
	
	public LoginPosition(String login, Position p) {
		super();
		this.login=login;
		this.position=p;
	}
	
	public String toString() {
		return "LoginPosition[id="+id+", login="+login+", position="+position.name()+"]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
