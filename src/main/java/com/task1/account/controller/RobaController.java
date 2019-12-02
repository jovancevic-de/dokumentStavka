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

import com.task1.account.dto.RobaDTO;
import com.task1.account.model.Roba;
import com.task1.account.service.RobaService;

@RestController
@RequestMapping("/api")
public class RobaController {

		@Autowired
		private ModelMapper modelMapper;
		
		private final RobaService robaService;
		
		public RobaController(RobaService robaService) {
			this.robaService = robaService;
		}
		
		@GetMapping("/roba")
		public ResponseEntity<List<RobaDTO>> getAllRoba() {
			List<Roba> listaRobe = robaService.getRoba();
			List<RobaDTO> listaRobaDTO = new ArrayList<>();
			for (Roba roba : listaRobe) {
				RobaDTO robaDTO = modelMapper.map(roba, RobaDTO.class);
			    listaRobaDTO.add(robaDTO);
			}
			return ResponseEntity.ok().body(listaRobaDTO);
		}
		
		@GetMapping("/roba/{id}")
		public ResponseEntity<RobaDTO> getOneRoba(@PathVariable int id){
			Roba roba = robaService.getOneRoba(id);
			RobaDTO robaDTO = modelMapper.map(roba, RobaDTO.class);
			return ResponseEntity.ok().body(robaDTO);
		}
		
		@PostMapping("/roba")
		public ResponseEntity<?> saveRoba(@RequestBody RobaDTO robaDTO){
			Roba roba = new Roba();
			roba.setNaziv(robaDTO.getNaziv());
			roba = robaService.saveRoba(roba);
			RobaDTO savedRoba = modelMapper.map(roba, RobaDTO.class);
			return new ResponseEntity<>(savedRoba, HttpStatus.CREATED );
		}
		
		@PutMapping("/roba/{id}")
			public ResponseEntity<RobaDTO> updateRoba(@RequestBody RobaDTO robaDTO, @PathVariable int id){
				Roba roba = robaService.getOneRoba(id);
				roba.setNaziv(robaDTO.getNaziv());
				roba = robaService.saveRoba(roba);
				RobaDTO savedRoba = modelMapper.map(roba, RobaDTO.class);
				return ResponseEntity.ok().body(savedRoba);
			}
		
		@DeleteMapping("/deleteRoba/{id}")
		public ResponseEntity<Object> deleteRoba(@PathVariable int id){
			Roba roba = robaService.getOneRoba(id);
			if (roba != null) {
				robaService.deleteRoba(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}
