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
import es.jmgd.football.rest.client.InformationClient;
import es.jmgd.football.rest.model.information.Information;

@Service
public class FootballService {

	private static final Logger log = LogManager.getLogger(FootballService.class);

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private InformationClient informationClient;

	public ResponseEntity<List<Player>> allPlayers() {
		if (!callToInformationService("allPlayers"))
			return ResponseEntity.noContent().build();

		List<Player> players = playerRepository.findAll();
		if (players != null && !players.isEmpty()) {
			return ResponseEntity.ok(players);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<List<Player>> teamPlayers(String name) {
		if (!callToInformationService("teamPlayers"))
			return ResponseEntity.noContent().build();

		List<Player> players = playerRepository.findPlayerByTeamNameIsLike(name);
		if (players != null && !players.isEmpty()) {
			return ResponseEntity.ok(players);
		} else {
			log.info("No matching teams for target: ", name);
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<List<Team>> allTeams() {
		if (!callToInformationService("allTeams"))
			return ResponseEntity.noContent().build();

		List<Team> teams = teamRepository.findAll();
		if (teams != null && !teams.isEmpty()) {
			return ResponseEntity.ok(teams);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<Void> addPlayer(Player player) {
		if (!callToInformationService("addPlayer"))
			return ResponseEntity.noContent().build();

		if (playerRepository.findById(player.getId()).isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			playerRepository.save(player);
			return ResponseEntity.noContent().build();
		}
	}

	private boolean callToInformationService(String apiCall) {
		Information information = new Information("Football", apiCall);
		if (informationClient.addRequestInformation(information).getBody() == true
				|| informationClient.addRequestInformation(information).getBody() == null) {
			return true;
		} else {
			return false;
		}
	}

}
