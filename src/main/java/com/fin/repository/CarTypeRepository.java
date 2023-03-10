package com.fin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fin.entity.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long>, JpaSpecificationExecutor<CarType> {

	CarType findByName(String carType);
}
