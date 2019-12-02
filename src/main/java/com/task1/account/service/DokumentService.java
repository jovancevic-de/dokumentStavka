package com.task1.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task1.account.model.Dokument;
import com.task1.account.repository.DokumentRepository;

@Service
public class DokumentService {
	private final DokumentRepository dokumentRepository;
	
	public DokumentService(DokumentRepository dokumentRepository) {
		this.dokumentRepository = dokumentRepository;
	}
	
	public List<Dokument> getAllDokumenti(){
		return dokumentRepository.findAll();
	}
	
	public Dokument getOneDokument(int id) {
		return dokumentRepository.findById(id).get();
	}
	
	public Dokument saveDokument(Dokument dokument) {
		return dokumentRepository.save(dokument);
	}
	
	public void deleteDokument(int id) {
		dokumentRepository.deleteById(id);
	}
}
