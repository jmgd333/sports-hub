package es.jmgd.formulaone.rest.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.jmgd.formulaone.database.entity.Driver;
import es.jmgd.formulaone.database.entity.Team;
import es.jmgd.formulaone.database.repository.DriverRepository;
import es.jmgd.formulaone.database.repository.TeamRepository;
import es.jmgd.formulaone.rest.client.InformationClient;
import es.jmgd.formulaone.rest.model.information.Information;

@Service
public class FormulaOneService {

	private static final Logger log = LogManager.getLogger(FormulaOneService.class);

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private InformationClient informationClient;

	public ResponseEntity<List<Driver>> allDrivers() {
		if (!callToInformationService("allDrivers"))
			return ResponseEntity.noContent().build();

		List<Driver> driverList = driverRepository.findAll();
		if (driverList != null && !driverList.isEmpty()) {
			return ResponseEntity.ok(driverList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<Driver> driverById(int id) {
		if (!callToInformationService("driverById"))
			return ResponseEntity.noContent().build();

		Optional<Driver> driver = driverRepository.findById(id);
		try {
			Driver responseDriver = driver.get();
			return ResponseEntity.ok(responseDriver);
		} catch (NoSuchElementException e) {
			log.info("This driver ID doesn't exist");
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<List<Team>> allTeams() {
		if (!callToInformationService("allTeams"))
			return ResponseEntity.noContent().build();

		List<Team> teamList = teamRepository.findAll();
		if (teamList != null && !teamList.isEmpty()) {
			return ResponseEntity.ok(teamList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	private boolean callToInformationService(String apiCall) {
		Information information = new Information("FormulaOne", apiCall);
		if (informationClient.addRequestInformation(information).getBody() == true
				|| informationClient.addRequestInformation(information).getBody() == null) {
			return true;
		} else {
			return false;
		}
	}
}
