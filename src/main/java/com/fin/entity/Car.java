package com.fin.entity;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
@Where(clause = "is_deleted=false")
@EqualsAndHashCode(callSuper = false)
public class Car extends BaseDomain {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "make", length = 50)
	private String make;

	@Column(name = "model", length = 50)
	private String model;

	@Column(name = "year", length = 10)
	private String year;

	@Column(name = "capacity", length = 20)
	private String capacity;

	@ManyToOne
	@JoinColumn(name = "car_type_id", referencedColumnName = "id")
	private CarType carType;

}
