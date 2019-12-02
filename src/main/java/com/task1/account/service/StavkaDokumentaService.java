package com.task1.account.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task1.account.model.StavkaDokumenta;
import com.task1.account.repository.StavkaDokumentaRepository;

@Service
public class StavkaDokumentaService {
	private final StavkaDokumentaRepository stavkaDokumentaRepository;
	
	public StavkaDokumentaService(StavkaDokumentaRepository stavkaDokumentaRepository) {
		this.stavkaDokumentaRepository = stavkaDokumentaRepository;
	}
	
	public List<StavkaDokumenta> getAllStavkeDokumenta(){
		return stavkaDokumentaRepository.findAll();
	}
	
	public List<StavkaDokumenta> getAllStavkeDokumentaByDokument(int id){
		return stavkaDokumentaRepository.findByDokumentId(id);
	}
 	
	public Page<StavkaDokumenta> getStavkeDokumentaByPage(Pageable pageable){
		return stavkaDokumentaRepository.findAll(pageable);
	}
	
	public Page<StavkaDokumenta> getAllStavkeDokumentaByDokumentWithPage(Pageable pageable, int id){
		return stavkaDokumentaRepository.findByDokumentId(pageable, id);
	}
	
	public StavkaDokumenta getOneStavkaDokumenta(int id) {
		return stavkaDokumentaRepository.findById(id).get();
	}
	
	public StavkaDokumenta saveStavkaDokumenta(StavkaDokumenta stavkaDokumenta) {
		return stavkaDokumentaRepository.save(stavkaDokumenta);
	}
	
	public void deleteStavkaDokumenta(int id) {
		stavkaDokumentaRepository.deleteById(id);
	}
}
