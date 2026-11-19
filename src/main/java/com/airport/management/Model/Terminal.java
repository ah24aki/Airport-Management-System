package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "terminals")
@Schema(description = "Airport terminal building details")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Terminal identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(nullable = false)
    @Schema(description = "Terminal name or code", example = "Terminal A", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    public Terminal() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}