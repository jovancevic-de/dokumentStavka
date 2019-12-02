package com.task1.account.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.task1.account.model.Dokument;
import com.task1.account.model.StavkaDokumenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DokumentDTO {
	
	private int id;
	
	private String naziv;
	
	private double iznos;
	
	private List<StavkaDokumenta> stavkeDokumenta = new ArrayList<>();
}
