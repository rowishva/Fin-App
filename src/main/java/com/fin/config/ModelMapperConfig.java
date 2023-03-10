package com.fin.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fin.entity.Car;
import com.fin.response.dto.CarDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		configProperty(modelMapper);
		return modelMapper;
	}

	public void configProperty(ModelMapper modelMapper) {
		carToCarDTO(modelMapper);
		carDTOToCar(modelMapper);
	}

	public void carDTOToCar(ModelMapper modelMapper) {
		TypeMap<CarDTO, Car> propertyMapper = modelMapper.createTypeMap(CarDTO.class, Car.class);
		propertyMapper.addMappings(mapper -> {
			mapper.map(source -> source.getId(), Car::setId);
			mapper.map(source -> source.getName(), Car::setName);
			mapper.map(source -> source.getMake(), Car::setMake);
			mapper.map(source -> source.getModel(), Car::setModel);
			mapper.map(source -> source.getYear(), Car::setYear);
			mapper.map(source -> source.getCapacity(), Car::setCapacity);
		});
		log.info("Convert -> CarDTO To Car");
	}

	public void carToCarDTO(ModelMapper modelMapper) {
		TypeMap<Car, CarDTO> propertyMapper = modelMapper.createTypeMap(Car.class, CarDTO.class);
		propertyMapper.addMappings(mapper -> {
			mapper.map(source -> source.getId(), CarDTO::setId);
			mapper.map(source -> source.getName(), CarDTO::setName);
			mapper.map(source -> source.getMake(), CarDTO::setMake);
			mapper.map(source -> source.getModel(), CarDTO::setModel);
			mapper.map(source -> source.getYear(), CarDTO::setYear);
			mapper.map(source -> source.getCapacity(), CarDTO::setCapacity);
		});
		log.info("Convert -> Car To CarDTO");
	}

}
