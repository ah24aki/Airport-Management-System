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

import com.airport.management.Model.Airline;
import com.airport.management.Service.AirlineService;

@CrossOrigin
@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService; 

    
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();  
    }

    @PostMapping
    public String saveAirline(@RequestBody Airline airline) {
        airlineService.saveAirline(airline); 
        return "Airline added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllAirlines(@RequestBody List<Airline> airlines) {
        airlineService.saveAllAirlines(airlines); 
        return "Successfully added " + airlines.size() + " airlines using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateAirline(@PathVariable int id, @RequestBody Airline airline) {
        airlineService.updateAirline(id, airline);
        return "Airline updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteAirline(@PathVariable int id) {
        airlineService.deleteAirline(id);
        return "Airline deleted successfully!";
    }
}