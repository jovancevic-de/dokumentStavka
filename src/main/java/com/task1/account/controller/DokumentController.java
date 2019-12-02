package com.task1.account.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task1.account.dto.DokumentDTO;
import com.task1.account.model.Dokument;
import com.task1.account.service.DokumentService;

@RestController
@RequestMapping("/api")
public class DokumentController {
	
	@Autowired
	private ModelMapper modelMapper;
		
	private final DokumentService dokumentService;
	
	public DokumentController(DokumentService dokumentService) {
		this.dokumentService = dokumentService;
	}
	
	@GetMapping("/dokumenti")
	public ResponseEntity<List<DokumentDTO>> getAllDokumenti(){
		List<Dokument> dokumenti = dokumentService.getAllDokumenti();
		List<DokumentDTO> listaDokumentDTO = new ArrayList<>();
		for (Dokument dokument : dokumenti) {
			DokumentDTO dokumentDTO = modelMapper.map(dokument, DokumentDTO.class);
			listaDokumentDTO.add(dokumentDTO);
		}
		return ResponseEntity.ok().body(listaDokumentDTO);
	}
	
	@GetMapping("/dokumenti/{id}")
	public ResponseEntity<DokumentDTO> getOneDokument(@PathVariable int id){
		Dokument dokument = dokumentService.getOneDokument(id);
		DokumentDTO dokumentDTO = modelMapper.map(dokument, DokumentDTO.class);
		return ResponseEntity.ok().body(dokumentDTO);
	}
	
	@PostMapping("/dokumenti")
	public ResponseEntity<?> saveDokument(@RequestBody DokumentDTO dokumentDTO) {
		Dokument dokument = new Dokument();
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument = dokumentService.saveDokument(dokument);
		DokumentDTO savedDokument = modelMapper.map(dokument, DokumentDTO.class);
		return new ResponseEntity<>(savedDokument, HttpStatus.CREATED);
	}
	
	@PutMapping("/dokumenti/{id}")
	public ResponseEntity<DokumentDTO> updateDokument(@RequestBody DokumentDTO dokumentDTO, @PathVariable int id){
		Dokument dokument = dokumentService.getOneDokument(id);
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument = dokumentService.saveDokument(dokument);
		DokumentDTO updatedDokument = modelMapper.map(dokument, DokumentDTO.class);
		return ResponseEntity.ok().body(updatedDokument);
	}
	
	@DeleteMapping("/deleteDokument/{id}")
	public ResponseEntity<Object> deleteDokument(@PathVariable int id){
		Dokument dokument = dokumentService.getOneDokument(id);
		if (dokument != null) {
			dokumentService.deleteDokument(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
