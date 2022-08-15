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

@Service
public class FormulaOneService {

	private static final Logger log = LogManager.getLogger(FormulaOneService.class);

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private TeamRepository teamRepository;

	public ResponseEntity<List<Driver>> allDrivers() {
		List<Driver> driverList = driverRepository.findAll();
		if (driverList != null && !driverList.isEmpty()) {
			return ResponseEntity.ok(driverList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<Driver> driverById(int id) {
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
		List<Team> teamList = teamRepository.findAll();
		if (teamList != null && !teamList.isEmpty()) {
			return ResponseEntity.ok(teamList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
