package com.fin.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

	private Long id;
	private String name;
	private String make;
	private String model;
	private String year;
	private String capacity;
	private Long carTypeId;
}
