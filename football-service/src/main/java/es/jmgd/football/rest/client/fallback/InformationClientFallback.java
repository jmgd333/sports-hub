package es.jmgd.football.rest.client.fallback;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import es.jmgd.football.rest.client.InformationClient;
import es.jmgd.football.rest.model.information.Information;

public class InformationClientFallback implements InformationClient {

	@Override
	public ResponseEntity<Void> addRequestInformation(@Valid Information information) {
		// TODO Auto-generated method stub
		return null;
	}

}