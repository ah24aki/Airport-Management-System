package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "airlines")
@Schema(description = "Represents an airline company operating in the airport")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique database ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Official airline name", example = "Turkish Airlines", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Column(nullable = false, unique = true, length = 10)
    @Schema(description = "Short IATA/ICAO code", example = "THY", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;

    public Airline() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}