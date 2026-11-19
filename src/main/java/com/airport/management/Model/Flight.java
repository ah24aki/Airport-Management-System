package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Schema(description = "Flight schedule and operational data")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Internal flight ID", example = "2024", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "flight_number", nullable = false)
    @Schema(description = "Unique flight number", example = "TK1903", requiredMode = Schema.RequiredMode.REQUIRED)
    private String flightNumber;

    @Column(name = "departure_time")
    @Schema(description = "Scheduled departure timestamp", example = "2026-05-20T10:00:00")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    @Schema(description = "Scheduled arrival timestamp", example = "2026-05-20T13:30:00")
    private LocalDateTime arrivalTime;

    @Schema(description = "Current flight operational status", example = "ON_TIME")
    private String status;

    @Column(name = "airplane_id")
    @Schema(description = "Assigned aircraft ID", example = "5")
    private int airplaneId;

    @Column(name = "gate_id")
    @Schema(description = "Assigned gate ID", example = "50")
    private int gateId;

    public Flight() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getAirplaneId() { return airplaneId; }
    public void setAirplaneId(int airplaneId) { this.airplaneId = airplaneId; }
    public int getGateId() { return gateId; }
    public void setGateId(int gateId) { this.gateId = gateId; }
}