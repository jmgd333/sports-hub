package es.jmgd.formulaone;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import es.jmgd.formulaone.database.entity.Driver;
import es.jmgd.formulaone.database.entity.Team;
import es.jmgd.formulaone.database.repository.TeamRepository;

@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FormulaoneServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FormulaoneServiceApplication.class, args);

		// Generating in memory data for H2 Database
		TeamRepository teamRepository = context.getBean(TeamRepository.class);

		Team teamAlpine = new Team("Alpine", Arrays.asList(new Driver("F.Alonso"), new Driver("E. Ocon")));
		Team teamMercedes = new Team("Mercedes", Arrays.asList(new Driver("L. Hamilton"), new Driver("G. Russell")));
		Team teamFerrari = new Team("Ferrari", Arrays.asList(new Driver("C. Sainz"), new Driver("C. Leclerc")));
		Team teamRedBull = new Team("RedBull", Arrays.asList(new Driver("M. Verstappen"), new Driver("S. Perez")));
		Team teamMcLaren = new Team("McLaren", Arrays.asList(new Driver("D. Ricciardo"), new Driver("L. Norris")));

		teamRepository.save(teamAlpine);
		teamRepository.save(teamMercedes);
		teamRepository.save(teamFerrari);
		teamRepository.save(teamRedBull);
		teamRepository.save(teamMcLaren);

	}

}
