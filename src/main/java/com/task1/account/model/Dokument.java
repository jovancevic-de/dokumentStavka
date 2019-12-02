package com.task1.account.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Dokument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String naziv;
	
	@Column(nullable = true)
	private double iznos;
	
	@OneToMany(mappedBy = "dokument", fetch = FetchType.LAZY)
	private List<StavkaDokumenta> stavkeDokumenta = new ArrayList<>();

	//customized getIznos()
	public double getIznos() {
		double iznos = 0;
		for (StavkaDokumenta stavka : this.stavkeDokumenta) {
			iznos += stavka.getCena();
		}
		return iznos;
	}
}
