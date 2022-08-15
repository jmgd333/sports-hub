package es.jmgd.football.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmgd.football.database.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	List<Player> findPlayerByTeamNameIsLike(String name);
}
