package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "boarding_passes")
@Schema(description = "Boarding pass linkage between flight and passenger")
public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique boarding pass serial ID", example = "5001", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "seat_number", nullable = false)
    @Schema(description = "Assigned seat location", example = "12A", requiredMode = Schema.RequiredMode.REQUIRED)
    private String seatNumber;

    @Column(name = "passenger_id")
    @Schema(description = "Holder passenger ID", example = "100")
    private int passengerId;

    @Column(name = "flight_id")
    @Schema(description = "Related flight ID", example = "2024")
    private int flightId;

    public BoardingPass() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }
    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }
}