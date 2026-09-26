package com.airport.management.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.airport.management.Model.Flight;

@Repository
public class FlightRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Flight> mapper = (rs, rowNum) -> {
        Flight f = new Flight();
        f.setId(rs.getInt("id"));
        f.setFlightNumber(rs.getString("flight_number"));
        f.setDepartureTime(rs.getObject("departure_time", LocalDateTime.class));
        f.setArrivalTime(rs.getObject("arrival_time", LocalDateTime.class));
        f.setStatus(rs.getString("status"));
        f.setAirplaneId(rs.getInt("airplane_id"));
        f.setGateId(rs.getInt("gate_id"));
        return f;
    };

    public List<Flight> findAll() {
        return jdbcTemplate.query("SELECT * FROM flights", mapper);
    }

    public int save(Flight f) {
        return jdbcTemplate.update("INSERT INTO flights (flight_number, departure_time, arrival_time, status, airplane_id, gate_id) VALUES (?, ?, ?, ?, ?, ?)", 
                f.getFlightNumber(), f.getDepartureTime(), f.getArrivalTime(), f.getStatus(), f.getAirplaneId(), f.getGateId());
    }
    
    public int[] saveAll(List<Flight> flights) {
        List<Object[]> batch = flights.stream()
                .map(f -> new Object[]{f.getFlightNumber(), f.getDepartureTime(), f.getArrivalTime(), f.getStatus(), f.getAirplaneId(), f.getGateId()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO flights (flight_number, departure_time, arrival_time, status, airplane_id, gate_id) VALUES (?, ?, ?, ?, ?, ?)", batch);
    }

    public int update(int id, Flight f) {
        return jdbcTemplate.update("UPDATE flights SET flight_number = ?, departure_time = ?, arrival_time = ?, status = ?, airplane_id = ?, gate_id = ? WHERE id = ?", 
                f.getFlightNumber(), f.getDepartureTime(), f.getArrivalTime(), f.getStatus(), f.getAirplaneId(), f.getGateId(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM flights WHERE id = ?", id);
    }
}