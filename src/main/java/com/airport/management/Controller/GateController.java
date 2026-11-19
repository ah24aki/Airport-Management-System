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

import com.airport.management.Model.Gate;
import com.airport.management.Service.GateService;


@CrossOrigin
@RestController
@RequestMapping("/gates")
public class GateController {

    private final GateService gateService;

    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping
    public List<Gate> getAllGates() {
        return gateService.getAllGates();
    }

    @PostMapping
    public String saveGate(@RequestBody Gate gate) {
        gateService.saveGate(gate);
        return "Gate added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllGates(@RequestBody List<Gate> gates) {
        gateService.saveAllGates(gates);
        return "Successfully added " + gates.size() + " gates using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateGate(@PathVariable int id, @RequestBody Gate gate) {
        gateService.updateGate(id, gate);
        return "Gate updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteGate(@PathVariable int id) {
        gateService.deleteGate(id);
        return "Gate deleted successfully!";
    }
}