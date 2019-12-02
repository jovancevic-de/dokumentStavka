package com.task1.account.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.task1.account.model.StavkaDokumenta;

@Repository
public interface StavkaDokumentaRepository extends JpaRepository<StavkaDokumenta, Integer> {
	List<StavkaDokumenta> findByDokumentId(int id);
	Page<StavkaDokumenta> findByDokumentId(Pageable pageable, int id);
	
}
