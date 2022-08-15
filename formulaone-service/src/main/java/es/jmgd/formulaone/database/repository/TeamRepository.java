package es.jmgd.formulaone.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmgd.formulaone.database.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
