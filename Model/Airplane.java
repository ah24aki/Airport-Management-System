package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "airplanes")
@Schema(description = "Aircraft details used for flights")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Internal aircraft ID", example = "5", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "model_name", nullable = false)
    @Schema(description = "Manufacturer and model name", example = "Boeing 737-800", requiredMode = Schema.RequiredMode.REQUIRED)
    private String modelName;

    @Schema(description = "Maximum passenger seating capacity", example = "189")
    private int capacity;

    @Column(name = "airline_id")
    @Schema(description = "Owner airline ID", example = "1")
    private int airlineId;

    public Airplane() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getAirlineId() { return airlineId; }
    public void setAirlineId(int airlineId) { this.airlineId = airlineId; }
}