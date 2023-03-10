package com.fin.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "id", "name", "make", "model", "year", "capacity" })
public class CarDTO {

	private Long id;
	private String name;
	private String make;
	private String model;
	private String year;
	private String capacity;

}
