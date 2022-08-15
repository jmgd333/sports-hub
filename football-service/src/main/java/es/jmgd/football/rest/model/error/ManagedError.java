package es.jmgd.football.rest.model.error;

import java.util.List;

import org.springframework.validation.FieldError;

public class ManagedError {

	public static String toString(List<FieldError> errors) {
		String errorStr = "";
		for (FieldError error : errors) {
			errorStr = error.getField() + ": " + error.getDefaultMessage();
		}
		return errorStr;
	}
}
