package es.jmgd.football.test.database.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.jmgd.football.database.entity.Player;
import es.jmgd.football.database.entity.Team;
import es.jmgd.football.database.repository.PlayerRepository;
import es.jmgd.football.database.repository.TeamRepository;

@DataJpaTest
public class PlayerRepositoryTest {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Test
	void ifEmptyStoredValues() {
		List<Player> playerList = playerRepository.findPlayerByTeamNameIsLike("Barça");
		assertThat(playerList).isEmpty();
	}

	@Test
	void ifNameMatchesWithStoredValue() {
		Team team = new Team("Real Madrid");
		teamRepository.save(team);
		Player player = new Player("Benzema", "Striker", team);
		playerRepository.save(player);

		List<Player> playerList = playerRepository.findPlayerByTeamNameIsLike("Real Madrid");
		assertThat(playerList).hasSize(1);
	}

	@Test
	void ifNameMatchesWithMultipleStoredValues() {
		Team team = new Team("Real Madrid");
		teamRepository.save(team);
		Player playerOne = new Player("Benzema", "Striker", team);
		Player playerTwo = new Player("Modric", "Midfielder", team);
		playerRepository.save(playerOne);
		playerRepository.save(playerTwo);

		List<Player> playerList = playerRepository.findPlayerByTeamNameIsLike("Real Madrid");
		assertThat(playerList).hasSize(2);
	}

	@Test
	void ifNameDoesntMatchesWithStoredValue() {
		Team team = new Team("Real Madrid");
		teamRepository.save(team);
		Player player = new Player("Benzema", "Striker", team);
		playerRepository.save(player);

		List<Player> playerList = playerRepository.findPlayerByTeamNameIsLike("Getafe");
		assertThat(playerList).isEmpty();
	}

}
