package es.jmgd.info.database.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "sportName name can't be empty")
	private String sportName;

	@NotNull(message = "apiCall name can't be empty")
	private String apiCall;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getApiCall() {
		return apiCall;
	}

	public void setApiCall(String apiCall) {
		this.apiCall = apiCall;
	}

	public Information() {
	}
}
