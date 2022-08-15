package es.jmgd.football.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "Player name can't be empty")
	private String name;

	@NotNull(message = "Player position cant't be empty")
	private String position;

	@NotNull(message = "Player need to have a team. Team can't be empty")
	@ManyToOne(targetEntity = Team.class, cascade = { CascadeType.MERGE })
	private Team team;

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player(String name, String position, Team team) {
		this.name = name;
		this.position = position;
		this.team = team;
	}

	public Player() {
	}

}
