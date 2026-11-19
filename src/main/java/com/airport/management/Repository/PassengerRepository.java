package com.airport.management.Repository;

import com.airport.management.Model.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PassengerRepository {

    private final JdbcTemplate jdbcTemplate;

    public PassengerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Passenger> mapper = (rs, rowNum) -> {
        Passenger p = new Passenger();
        p.setId(rs.getInt("id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setPassportNumber(rs.getString("passport_number"));
        return p;
    };

    public List<Passenger> findAll() {
        return jdbcTemplate.query("SELECT * FROM passengers", mapper);
    }

    public int save(Passenger p) {
        return jdbcTemplate.update("INSERT INTO passengers (first_name, last_name, passport_number) VALUES (?, ?, ?)", 
                p.getFirstName(), p.getLastName(), p.getPassportNumber());
    }

    public int[] saveAll(List<Passenger> passengers) {
        List<Object[]> batch = passengers.stream()
                .map(p -> new Object[]{p.getFirstName(), p.getLastName(), p.getPassportNumber()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO passengers (first_name, last_name, passport_number) VALUES (?, ?, ?)", batch);
    }

    public int update(int id, Passenger p) {
        return jdbcTemplate.update("UPDATE passengers SET first_name = ?, last_name = ?, passport_number = ? WHERE id = ?", 
                p.getFirstName(), p.getLastName(), p.getPassportNumber(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM passengers WHERE id = ?", id);
    }
}