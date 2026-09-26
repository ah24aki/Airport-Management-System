package com.airport.management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airport.management.Model.Airplane;
import com.airport.management.Repository.AirplaneRepository;

@Service
public class AirplaneService {

	private final AirplaneRepository airplaneRepository;

	public AirplaneService(AirplaneRepository airplaneRepository) {
		this.airplaneRepository = airplaneRepository;
	}

	private void validateAirplane(Airplane airplane) {
		if (airplane.getModelName() == null || airplane.getModelName().trim().isEmpty()) {
			throw new IllegalArgumentException("Error: Airplane model name cannot be empty!");
		}
		if (airplane.getCapacity() <= 0) {
			throw new IllegalArgumentException("Error: Airplane capacity must be greater than zero!");
		}
		if (airplane.getAirlineId() <= 0) {
			throw new IllegalArgumentException("Error: Invalid Airline ID!");
		}
	}

	public List<Airplane> getAllAirplanes() {
		return airplaneRepository.findAll();
	}

	public void saveAirplane(Airplane airplane) {
        validateAirplane(airplane);  
        airplaneRepository.save(airplane);
    }

	public void saveAllAirplanes(List<Airplane> airplanes) {
		for (Airplane a : airplanes) {
			validateAirplane(a);
		}
		airplaneRepository.saveAll(airplanes);
	}

	public void updateAirplane(int id, Airplane airplane) {
		validateAirplane(airplane);
		airplaneRepository.update(id, airplane);
	}

	public void deleteAirplane(int id) {
		airplaneRepository.deleteById(id);
	}
}