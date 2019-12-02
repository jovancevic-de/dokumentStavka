package com.task1.account.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.task1.account.dto.StavkaDokumentaDTO;
import com.task1.account.model.Dokument;
import com.task1.account.model.Roba;
import com.task1.account.model.StavkaDokumenta;
import com.task1.account.service.DokumentService;
import com.task1.account.service.RobaService;
import com.task1.account.service.StavkaDokumentaService;

@RestController
@RequestMapping("/api")
public class StavkaDokumentaController {
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private DokumentService dokumentService;
	
	@Autowired
	private RobaService robaService;
	
	private final StavkaDokumentaService stavkaDokumentaService;
	
	public StavkaDokumentaController(StavkaDokumentaService stavkaDokumentaService) {
		this.stavkaDokumentaService = stavkaDokumentaService;
	}
	
	@GetMapping("/stavkeDokumenta")
	public ResponseEntity<List<StavkaDokumentaDTO>> getAllStavkeDokumenta(){
		List<StavkaDokumenta> stavkeDokumenta = stavkaDokumentaService.getAllStavkeDokumenta();
		List<StavkaDokumentaDTO> stavkeDokumentaDTO = new ArrayList<>();
		for (StavkaDokumenta stavkaDokumenta : stavkeDokumenta) {
			StavkaDokumentaDTO stavkaDokumentaDTO = modelMapper.map(stavkaDokumenta, StavkaDokumentaDTO.class);
			stavkeDokumentaDTO.add(stavkaDokumentaDTO);
		}
		return ResponseEntity.ok().body(stavkeDokumentaDTO);
	}
	
	@GetMapping("/stavkeDokumenta/{id}")
	public ResponseEntity<StavkaDokumentaDTO> getOneStavkaDokumenta(@PathVariable int id){
		StavkaDokumenta stavkaDokumenta = stavkaDokumentaService.getOneStavkaDokumenta(id);
		StavkaDokumentaDTO stavkaDokumentaDTO = modelMapper.map(stavkaDokumenta, StavkaDokumentaDTO.class);
		return ResponseEntity.ok().body(stavkaDokumentaDTO);
	}
	
	@PostMapping("/stavkeDokumenta")
	public ResponseEntity<?> saveStavkaDokumenta(@RequestBody StavkaDokumentaDTO stavkaDokumentaDTO){
		Roba roba = robaService.getOneRoba(stavkaDokumentaDTO.getRoba().getId());
		Dokument dokument = dokumentService.getOneDokument(stavkaDokumentaDTO.getDokument().getId());
		StavkaDokumenta stavkaDokumenta = new StavkaDokumenta();
		stavkaDokumenta.setDokument(dokument);
		stavkaDokumenta.setRoba(roba);
		stavkaDokumenta.setCena(stavkaDokumentaDTO.getCena());
		stavkaDokumenta.setKolicina(stavkaDokumentaDTO.getKolicina());
		stavkaDokumenta = stavkaDokumentaService.saveStavkaDokumenta(stavkaDokumenta);
		StavkaDokumentaDTO savedStavkaDokumenta = modelMapper.map(stavkaDokumenta, StavkaDokumentaDTO.class);
		return new ResponseEntity<>(savedStavkaDokumenta, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/stavkeDokumenta/{id}")
	public ResponseEntity<StavkaDokumentaDTO> updateStavkaDokumenta(@RequestBody StavkaDokumentaDTO stavkaDokumentaDTO, @PathVariable int id){
		Roba roba = robaService.getOneRoba(stavkaDokumentaDTO.getRoba().getId());
		Dokument dokument = dokumentService.getOneDokument(stavkaDokumentaDTO.getDokument().getId());
		StavkaDokumenta stavkaDokumenta = stavkaDokumentaService.getOneStavkaDokumenta(id);
		stavkaDokumenta.setDokument(dokument);
		stavkaDokumenta.setRoba(roba);
		stavkaDokumenta.setCena(stavkaDokumentaDTO.getCena());
		stavkaDokumenta.setKolicina(stavkaDokumentaDTO.getKolicina());
		stavkaDokumenta = stavkaDokumentaService.saveStavkaDokumenta(stavkaDokumenta);
		StavkaDokumentaDTO savedStavkaDokumenta = modelMapper.map(stavkaDokumenta, StavkaDokumentaDTO.class);
		return  ResponseEntity.ok().body(savedStavkaDokumenta);
	}
	
	@DeleteMapping("/deleteStavkaDokumenta/{id}")
	public ResponseEntity<Object> deleteStavkaDokumenta(@PathVariable int id){
		StavkaDokumenta stavkaDokumenta = stavkaDokumentaService.getOneStavkaDokumenta(id);
		if (stavkaDokumenta != null) {
			stavkaDokumentaService.deleteStavkaDokumenta(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
