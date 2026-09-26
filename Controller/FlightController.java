package com.airport.management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.management.Model.Flight;
import com.airport.management.Service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping
    public String saveFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
        return "Flight added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllFlights(@RequestBody List<Flight> flights) {
        flightService.saveAllFlights(flights);
        return "Successfully added " + flights.size() + " flights using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        flightService.updateFlight(id, flight);
        return "Flight updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
        return "Flight deleted successfully!";
    }
}