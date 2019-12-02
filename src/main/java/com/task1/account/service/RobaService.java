package com.task1.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.task1.account.repository.RobaRepository;
import com.task1.account.model.*;

@Service
public class RobaService {
	private final RobaRepository robaRepository;
	
	public RobaService(RobaRepository robaRepository) {
		this.robaRepository = robaRepository;
	}
	
	public List<Roba> getRoba(){
		return robaRepository.findAll();
	}
	
	public Roba getOneRoba(int id) {
		return robaRepository.findById(id).get();
	}
	
	public Roba saveRoba(Roba roba) {
		return robaRepository.save(roba);
	}
	
	public void deleteRoba(int id) {
		robaRepository.deleteById(id);
	}
}
