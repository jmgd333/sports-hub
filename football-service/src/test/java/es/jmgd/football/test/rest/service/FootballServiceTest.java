package es.jmgd.football.test.rest.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.jmgd.football.database.entity.Player;
import es.jmgd.football.database.repository.PlayerRepository;
import es.jmgd.football.database.repository.TeamRepository;
import es.jmgd.football.rest.client.InformationClient;

public class FootballServiceTest {

	@Mock
	private PlayerRepository playerRepository;

	@Mock
	private TeamRepository teamRepository;

	@Mock
	private InformationClient informationClient;

	private AutoCloseable autoClosable;

	@BeforeEach
	void setUp() {
		autoClosable = MockitoAnnotations.openMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
		autoClosable.close();
	}

	@Test
	void allPlayers() {
		playerRepository.findAll();
		verify(playerRepository).findAll();
	}

	@Test
	@Disabled
	void teamPlayers() {
		String name = "Juan";
		playerRepository.findPlayerByTeamNameIsLike(name);
		verify(playerRepository).findPlayerByTeamNameIsLike(name);
	}

	@Test
	void allTeams() {
		teamRepository.findAll();
		verify(teamRepository).findAll();
	}

	@Test
	@Disabled
	void addPlayer(Player player) {

	}

	@Test
	@Disabled
	void callToInformationService(String apiCall) {

	}
}
