package es.jmgd.formulaone.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jmgd.formulaone.database.entity.Driver;
import es.jmgd.formulaone.database.entity.Team;
import es.jmgd.formulaone.rest.service.FormulaOneService;

@RestController
@RequestMapping(path = "/formula-one", produces = "application/json")
public class FormulaOneController {

	@Autowired
	private FormulaOneService formulaOneService;

	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> allDrivers() {
		return formulaOneService.allDrivers();
	}

	@GetMapping("/driver/{id}")
	public ResponseEntity<Driver> driverById(@PathVariable("id") int id) {
		return formulaOneService.driverById(id);
	}

	@GetMapping("/teams")
	public ResponseEntity<List<Team>> allTeams() {
		return formulaOneService.allTeams();
	}
}
