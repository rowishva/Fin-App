package com.fin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fin.constants.ApplicationConstants;
import com.fin.entity.Car;
import com.fin.entity.CarType;
import com.fin.exception.ResourceNotFoundException;
import com.fin.repository.CarRepository;
import com.fin.repository.CarTypeRepository;
import com.fin.request.dto.RequestDTO;
import com.fin.response.BaseResponse;
import com.fin.response.dto.CarDTO;
import com.fin.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarTypeRepository carTypeRepository;

	@Override
	public BaseResponse<CarDTO> createCar(RequestDTO requestDTO) {
		log.info("Calling CarServiceImpl.createCar()");

		Optional<CarType> carType = carTypeRepository.findById(requestDTO.getCarTypeId());
		if (carType.isEmpty()) {
			throw new ResourceNotFoundException(
					ApplicationConstants.ERROR_MSG_CAR_TYPE_NOT_FOUND + requestDTO.getCarTypeId());
		}

		Car car = modelMapper.map(requestDTO, Car.class);
		car.setCarType(carType.get());
		car = carRepository.save(car);
		CarDTO carDTO = modelMapper.map(car, CarDTO.class);
		BaseResponse<CarDTO> response = new BaseResponse<CarDTO>(HttpStatus.CREATED.value(),
				ApplicationConstants.SUCCESS, carDTO, null);
		return response;
	}

	@Override
	public BaseResponse<CarDTO> updateCar(RequestDTO requestDTO) {

		log.info("Calling CarServiceImpl.updateCar()");
		Optional<Car> car = carRepository.findById(requestDTO.getId());
		if (car.isEmpty()) {
			throw new ResourceNotFoundException(ApplicationConstants.ERROR_MSG_CAR_NOT_FOUND + requestDTO.getId());
		}
		Car update = car.get();
		modelMapper.map(requestDTO, update);
		update = carRepository.save(update);
		CarDTO carDTO = modelMapper.map(car, CarDTO.class);
		BaseResponse<CarDTO> response = new BaseResponse<CarDTO>(HttpStatus.OK.value(), ApplicationConstants.SUCCESS,
				carDTO, null);
		return response;
	}

	@Override
	public BaseResponse<CarDTO> deleteCar(Long id) {
		log.info("Calling CarServiceImpl.deleteCar()");
		Optional<Car> car = carRepository.findById(id);
		if (car.isEmpty()) {
			throw new ResourceNotFoundException(ApplicationConstants.ERROR_MSG_CAR_NOT_FOUND + id);
		}
		Car deleteCar = car.get();
		deleteCar.setDeleted(true);
		carRepository.save(deleteCar);
		BaseResponse<CarDTO> response = new BaseResponse<CarDTO>(HttpStatus.NO_CONTENT.value(),
				ApplicationConstants.SUCCESS, null, null);
		return response;
	}

	@Override
	public BaseResponse<CarDTO> getCarByCarType(String name) {
		log.info("Calling CarServiceImpl.getCarByCarType()");
		CarType carType = carTypeRepository.findByName(name);
		if (carType == null) {
			throw new ResourceNotFoundException(ApplicationConstants.ERROR_MSG_CAR_TYPE_NOT_FOUND + name);
		}

		List<Car> carList = carRepository.findByCarType(carType);
		List<CarDTO> carListDTO = new ArrayList<CarDTO>();
		if (carList != null && carList.size() > 0) {
			carListDTO.addAll(
					carList.stream().map(car -> modelMapper.map(car, CarDTO.class)).collect(Collectors.toList()));
		}
		BaseResponse<CarDTO> response = new BaseResponse<CarDTO>(HttpStatus.OK.value(), ApplicationConstants.SUCCESS,
				null, carListDTO);
		return response;
	}

}
