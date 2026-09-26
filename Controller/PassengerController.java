package com.airport.management.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.airport.management.Model.Passenger;
import com.airport.management.Service.PassengerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @PostMapping
    public String savePassenger(@RequestBody Passenger passenger) {
        passengerService.savePassenger(passenger);
        return "Passenger added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllPassengers(@RequestBody List<Passenger> passengers) {
        passengerService.saveAllPassengers(passengers);
        return "Successfully added " + passengers.size() + " passengers using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updatePassenger(@PathVariable int id, @RequestBody Passenger passenger) {
        passengerService.updatePassenger(id, passenger);
        return "Passenger updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable int id) {
        passengerService.deletePassenger(id);
        return "Passenger deleted successfully!";
    }
}