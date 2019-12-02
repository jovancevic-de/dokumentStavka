package com.task1.account.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
	private int currentPage;
	private int itemsPerPage;
	private long totalItems;
	private Collection<T> items;
}
