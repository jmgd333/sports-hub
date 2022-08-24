package es.jmgd.info.rest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.jmgd.info.database.entity.Information;
import es.jmgd.info.database.repository.InformationRepository;

@Service
public class InformationService {

	private static final Logger log = LogManager.getLogger(InformationService.class);

	@Autowired
	private InformationRepository informationRepository;

	public ResponseEntity<Boolean> addRequestInformation(Information information) {
		if (informationRepository.findById(information.getId()).isPresent()) {
			log.info("La información ya fue previamente guardada");
			return ResponseEntity.badRequest().build();
		} else {
			informationRepository.save(information);
			log.info("Se guardó la información");
			return ResponseEntity.ok(true);
		}
	}

}
