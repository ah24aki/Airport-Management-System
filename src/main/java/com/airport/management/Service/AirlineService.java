package com.airport.management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airport.management.Model.Airline;
import com.airport.management.Repository.AirlineRepository;

@Service       
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    private void validateAirline(Airline airline) {
        if (airline.getName() == null || airline.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Airline name cannot be empty!");
        }
        if (airline.getCode() == null || airline.getCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Airline code cannot be empty!");
        }
        if (airline.getCode().length() > 10) {
            throw new IllegalArgumentException("Error: Airline code cannot exceed 10 characters!");
        }
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public void saveAirline(Airline airline) {
        validateAirline(airline);
        airlineRepository.save(airline);
    }

    public void saveAllAirlines(List<Airline> airlines) {
        for (Airline a : airlines) {
            validateAirline(a);
        }
        airlineRepository.saveAll(airlines);
    }

    public void updateAirline(int id, Airline airline) {
        validateAirline(airline);          
        airlineRepository.update(id, airline);
    }

    public void deleteAirline(int id) {
        airlineRepository.deleteById(id);
    }
}