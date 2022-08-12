package es.jmgd.football.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmgd.football.database.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
	List<Driver> findDriversByNameIsLike(String name);
}
