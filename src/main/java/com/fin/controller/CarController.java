package com.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.constants.ApplicationConstants;
import com.fin.request.dto.RequestDTO;
import com.fin.response.BaseResponse;
import com.fin.response.dto.CarDTO;
import com.fin.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ApplicationConstants.SERVICE_ENDPOINT_API_CAR)
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	public BaseResponse<CarDTO> createDevice(@RequestBody RequestDTO requestDTO) {
		log.info("Calling CarController.createCar()");
		return carService.createCar(requestDTO);
	}

	@PutMapping
	public BaseResponse<CarDTO> updateDevice(@RequestBody RequestDTO requestDTO) {
		log.info("Calling CarController.updateCar()");
		return carService.updateCar(requestDTO);
	}

	@DeleteMapping(value = ApplicationConstants.SERVICE_ENDPOINT_ID)
	public BaseResponse<CarDTO> getDevice(@PathVariable("id") Long id) {
		log.info("Calling CarController.deleteCar ()");
		return carService.deleteCar(id);
	}

	@GetMapping(value = ApplicationConstants.SERVICE_ENDPOINT_CAR_TYPE)
	public BaseResponse<CarDTO> getCarByCarType(@PathVariable("carType") String name) {
		log.info("Calling CarController.getCarByCarType()");
		return carService.getCarByCarType(name);
	}

}
