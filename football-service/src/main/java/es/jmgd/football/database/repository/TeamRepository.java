package es.jmgd.football.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmgd.football.database.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
