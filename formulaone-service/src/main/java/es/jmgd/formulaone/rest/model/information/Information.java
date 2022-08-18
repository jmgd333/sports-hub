package es.jmgd.formulaone.rest.model.information;

import javax.validation.constraints.NotNull;

public record Information(@NotNull(message = "sportName name can't be empty") String sportName,
		@NotNull(message = "apiCall name can't be empty") String apiCall) {
}
