package com.javaspringlabo.monproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringlabo.monproject.model.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Integer> {

}