package com.fin.service;

import org.springframework.stereotype.Service;

import com.fin.request.dto.RequestDTO;
import com.fin.response.BaseResponse;
import com.fin.response.dto.CarDTO;

@Service
public interface CarService {

	public BaseResponse<CarDTO> createCar(RequestDTO requestDTO);

	public BaseResponse<CarDTO> updateCar(RequestDTO requestDTO);

	public BaseResponse<CarDTO> deleteCar(Long id);

	public BaseResponse<CarDTO> getCarByCarType(String carType);

}
