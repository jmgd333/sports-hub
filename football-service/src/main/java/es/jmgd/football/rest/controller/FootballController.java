package es.jmgd.football.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jmgd.football.database.entity.Player;
import es.jmgd.football.database.entity.Team;
import es.jmgd.football.rest.service.FootballService;

@RestController
@RequestMapping(path = "/football")
public class FootballController {

	@Autowired
	private FootballService footballService;

	@GetMapping("/players")
	public ResponseEntity<List<Player>> allPlayers() {
		return footballService.allPlayers();
	}

	@GetMapping("/{team}/players")
	public ResponseEntity<List<Player>> teamPlayers(@PathVariable("team") String teamName) {
		return footballService.teamPlayers(teamName);
	}

	@GetMapping("/teams")
	public ResponseEntity<List<Team>> allTeams() {
		return footballService.allTeams();
	}

}
