package es.jmgd.football.rest.client.fallback;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import es.jmgd.football.rest.client.InformationClient;
import es.jmgd.football.rest.model.information.Information;

public class InformationClientFallback implements InformationClient {

	@Override
	public ResponseEntity<Boolean> addRequestInformation(@Valid Information information) {
		return ResponseEntity.ok(false);
	}

}