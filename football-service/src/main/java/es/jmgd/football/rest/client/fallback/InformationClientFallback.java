package es.jmgd.football.rest.client.fallback;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import es.jmgd.football.rest.client.InformationClient;
import es.jmgd.football.rest.model.information.Information;

@Component
public class InformationClientFallback implements InformationClient {
	private static final Logger log = LogManager.getLogger(InformationClientFallback.class);

	@Override
	public ResponseEntity<Boolean> addRequestInformation(@Valid @RequestBody Information information) {
		log.info("Service info-service/information not available. Executing fallback");
		return ResponseEntity.ok(false);
	}

}