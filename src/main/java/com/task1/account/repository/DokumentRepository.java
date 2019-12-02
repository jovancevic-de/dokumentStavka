package com.task1.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task1.account.model.Dokument;

@Repository
public interface DokumentRepository extends JpaRepository<Dokument, Integer> {
	
}
