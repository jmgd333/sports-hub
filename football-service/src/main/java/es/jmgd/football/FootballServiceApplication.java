package es.jmgd.football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import es.jmgd.football.database.entity.Player;
import es.jmgd.football.database.entity.Team;
import es.jmgd.football.database.repository.PlayerRepository;
import es.jmgd.football.database.repository.TeamRepository;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FootballServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FootballServiceApplication.class, args);

		// Generating in memory data for H2 Database
		TeamRepository teamRepository = context.getBean(TeamRepository.class);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);

		// Load data from Team 1
		Team team = new Team("Real Madrid");
		teamRepository.save(team);

		Player player = new Player("Benzema", "Striker", team);
		playerRepository.save(player);
		player = new Player("Modric", "Midfield", team);
		playerRepository.save(player);
		player = new Player("Kroos", "Midfield", team);
		playerRepository.save(player);
		player = new Player("Alaba", "Defense", team);
		playerRepository.save(player);
		player = new Player("Courtois", "GoalKeeper", team);
		playerRepository.save(player);

		// Load data from Team 2
		team = new Team("Barcelona");
		teamRepository.save(team);

		player = new Player("Lewandosky", "Striker", team);
		playerRepository.save(player);
		player = new Player("Iniesta", "Midfield", team);
		playerRepository.save(player);
		player = new Player("Xavi", "Midfield", team);
		playerRepository.save(player);
		player = new Player("Puyol", "Defense", team);
		playerRepository.save(player);
		player = new Player("T. Stegen", "GoalKeeper", team);
		playerRepository.save(player);

	}

}
