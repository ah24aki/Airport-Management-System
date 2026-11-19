package com.airport.management.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
@Schema(description = "Detailed information about a passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique passenger ID", example = "100", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "first_name", nullable = false)
    @Schema(description = "Passenger's first name", example = "Ahmed", requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Schema(description = "Passenger's family name", example = "Al-Gabri", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @Column(name = "passport_number", nullable = false, unique = true)
    @Schema(description = "Global passport identification number", example = "P12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    private String passportNumber;

    public Passenger() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
}