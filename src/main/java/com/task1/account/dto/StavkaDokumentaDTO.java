package com.task1.account.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task1.account.model.Dokument;
import com.task1.account.model.Roba;
import com.task1.account.model.StavkaDokumenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StavkaDokumentaDTO {
	
	private int id;
		
	private int kolicina;
	
	private double cena;
	
	private Dokument dokument;
	
	private Roba roba;
}
