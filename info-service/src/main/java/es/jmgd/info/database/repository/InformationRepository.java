package es.jmgd.info.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmgd.info.database.entity.Information;

public interface InformationRepository extends JpaRepository<Information, Integer> {

}
