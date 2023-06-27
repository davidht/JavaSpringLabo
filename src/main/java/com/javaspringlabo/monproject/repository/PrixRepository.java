package com.javaspringlabo.monproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaspringlabo.monproject.model.Prix;

public interface PrixRepository extends JpaRepository<Prix, Integer> {
	
	@Query("SELECT p FROM Prix p WHERE p.marque.id = :marqueId")
	List<Prix> findPrixByMarqueId(@Param("marqueId") Integer marqueId);
}