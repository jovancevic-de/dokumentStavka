package com.task1.account.repository;

import org.springframework.stereotype.Repository;

import com.task1.account.model.Roba;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RobaRepository extends JpaRepository<Roba, Integer> {

}
