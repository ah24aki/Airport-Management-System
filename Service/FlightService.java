package com.airport.management.Service;

import com.airport.management.Model.Flight;
import com.airport.management.Repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    private void validateFlight(Flight flight) {
        if (flight.getFlightNumber() == null || flight.getFlightNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Flight number cannot be empty!");
        }
        if (flight.getDepartureTime() == null || flight.getDepartureTime().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Departure time must be specified!");
        }
        if (flight.getArrivalTime() == null || flight.getArrivalTime().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Arrival time must be specified!");
        }
        if (flight.getStatus() == null || flight.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Flight status cannot be empty!");
        }
        if (flight.getAirplaneId() <= 0) {
            throw new IllegalArgumentException("Error: Invalid Airplane ID! Must be greater than zero.");
        }
        if (flight.getGateId() <= 0) {
            throw new IllegalArgumentException("Error: Invalid Gate ID! Must be greater than zero.");
        }
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void saveFlight(Flight flight) {
        validateFlight(flight); 
        flightRepository.save(flight);
    }

    public void saveAllFlights(List<Flight> flights) {
        for (Flight f : flights) {
            validateFlight(f);
        }
        flightRepository.saveAll(flights);
    }

    public void updateFlight(int id, Flight flight) {
        validateFlight(flight); 
        flightRepository.update(id, flight);
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
}