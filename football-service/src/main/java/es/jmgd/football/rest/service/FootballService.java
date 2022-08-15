package es.jmgd.football.rest.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.jmgd.football.database.entity.Player;
import es.jmgd.football.database.entity.Team;
import es.jmgd.football.database.repository.PlayerRepository;
import es.jmgd.football.database.repository.TeamRepository;

@Service
public class FootballService {

	private static final Logger log = LogManager.getLogger(FootballService.class);

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	public ResponseEntity<List<Player>> allPlayers() {
		List<Player> players = playerRepository.findAll();
		if (players != null && !players.isEmpty()) {
			return ResponseEntity.ok(players);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<List<Player>> teamPlayers(String name) {
		List<Player> players = playerRepository.findPlayerByTeamNameIsLike(name);
		if (players != null && !players.isEmpty()) {
			return ResponseEntity.ok(players);
		} else {
			log.info("No matching teams for target: ", name);
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<List<Team>> allTeams() {
		List<Team> teams = teamRepository.findAll();
		if (teams != null && !teams.isEmpty()) {
			return ResponseEntity.ok(teams);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<Void> addPlayer(Player player) {
		if (playerRepository.findById(player.getId()).isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			playerRepository.save(player);
			return ResponseEntity.noContent().build();
		}
	}

}
