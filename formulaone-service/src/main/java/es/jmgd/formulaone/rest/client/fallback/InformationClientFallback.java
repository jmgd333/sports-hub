package es.jmgd.formulaone.rest.client.fallback;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import es.jmgd.formulaone.rest.client.InformationClient;
import es.jmgd.formulaone.rest.model.information.Information;

@Component
public class InformationClientFallback implements InformationClient {
	private static final Logger log = LogManager.getLogger(InformationClientFallback.class);

	@Override
	public ResponseEntity<Boolean> addRequestInformation(@Valid Information information) {
		log.info("Service info-service/information not available. Executing fallback");
		return ResponseEntity.ok(false);
	}

}
