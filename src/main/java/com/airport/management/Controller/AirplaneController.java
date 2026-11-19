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

import com.airport.management.Model.Airplane;
import com.airport.management.Service.AirplaneService;


@CrossOrigin
@RestController
@RequestMapping("/airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @PostMapping
    public String saveAirplane(@RequestBody Airplane airplane) {
        airplaneService.saveAirplane(airplane);
        return "Airplane added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllAirplanes(@RequestBody List<Airplane> airplanes) {
        airplaneService.saveAllAirplanes(airplanes);
        return "Successfully added " + airplanes.size() + " airplanes using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateAirplane(@PathVariable int id, @RequestBody Airplane airplane) {
        airplaneService.updateAirplane(id, airplane);
        return "Airplane updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteAirplane(@PathVariable int id) {
        airplaneService.deleteAirplane(id);
        return "Airplane deleted successfully!";
    }
}