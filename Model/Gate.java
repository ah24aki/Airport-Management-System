package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "gates")
@Schema(description = "Specific gate location within a terminal")
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Gate unique ID", example = "50", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "gate_number", nullable = false)
    @Schema(description = "Physical gate number/letter", example = "A-12", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gateNumber;

    @Column(name = "is_available")
    @Schema(description = "Current availability status of the gate", example = "true")
    private Boolean isAvailable;

    @Column(name = "terminal_id")
    @Schema(description = "ID of the terminal where this gate is located", example = "1")
    private int terminalId;

    public Gate() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getGateNumber() { return gateNumber; }
    public void setGateNumber(String gateNumber) { this.gateNumber = gateNumber; }
    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
    public int getTerminalId() { return terminalId; }
    public void setTerminalId(int terminalId) { this.terminalId = terminalId; }
}