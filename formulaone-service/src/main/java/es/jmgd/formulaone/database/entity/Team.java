package es.jmgd.formulaone.database.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "Team name can't be empty")
	private String name;

	@NotNull(message = "Team need to have drivers. Drivers can't be empty")
	@OneToMany(targetEntity = Driver.class, cascade = { CascadeType.ALL })
	private List<Driver> driver;

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

	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}

	public Team(String name, List<Driver> driver) {
		this.name = name;
		this.driver = driver;
	}

	public Team() {
	}
}
