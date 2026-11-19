package com.airport.management.Service;

import com.airport.management.Model.Gate;
import com.airport.management.Repository.GateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GateService {

    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    private void validateGate(Gate gate) {
        if (gate.getGateNumber() == null || gate.getGateNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Gate number cannot be empty!");
        }
        if (gate.getTerminalId() <= 0) {
            throw new IllegalArgumentException("Error: Invalid Terminal ID! Must be greater than zero.");
        }
    }

    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }

    public void saveGate(Gate gate) {
        validateGate(gate);
        gateRepository.save(gate);
    }

    public void saveAllGates(List<Gate> gates) {
        for (Gate g : gates) {
            validateGate(g);
        }
        gateRepository.saveAll(gates);
    }

    public void updateGate(int id, Gate gate) {
        validateGate(gate); 
        gateRepository.update(id, gate);
    }

    public void deleteGate(int id) {
        gateRepository.deleteById(id);
    }
}