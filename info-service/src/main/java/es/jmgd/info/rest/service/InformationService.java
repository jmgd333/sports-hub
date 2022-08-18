package es.jmgd.info.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.jmgd.info.database.entity.Information;
import es.jmgd.info.database.repository.InformationRepository;

@Service
public class InformationService {

	@Autowired
	private InformationRepository informationRepository;

	public ResponseEntity<Void> addRequestInformation(Information information) {
		if (informationRepository.findById(information.getId()).isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			informationRepository.save(information);
			return ResponseEntity.noContent().build();
		}
	}

}
