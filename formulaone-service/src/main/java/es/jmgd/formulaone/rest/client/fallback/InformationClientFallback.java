package es.jmgd.formulaone.rest.client.fallback;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import es.jmgd.formulaone.rest.client.InformationClient;
import es.jmgd.formulaone.rest.model.information.Information;

public class InformationClientFallback implements InformationClient {

	@Override
	public ResponseEntity<Void> addRequestInformation(@Valid Information information) {
		// TODO Auto-generated method stub
		return null;
	}

}
