package com.airport.management.Repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.airport.management.Model.BoardingPass;

@Repository
public class BoardingPassRepository {

    private final JdbcTemplate jdbcTemplate;

    public BoardingPassRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<BoardingPass> mapper = (rs, rowNum) -> {
        BoardingPass b = new BoardingPass();
        b.setId(rs.getInt("id"));
        b.setSeatNumber(rs.getString("seat_number"));
        b.setPassengerId(rs.getInt("passenger_id"));
        b.setFlightId(rs.getInt("flight_id"));
        return b;
    };

    public List<BoardingPass> findAll() {
        return jdbcTemplate.query("SELECT * FROM boarding_passes", mapper);
    }

    public int save(BoardingPass b) {
        return jdbcTemplate.update("INSERT INTO boarding_passes (seat_number, passenger_id, flight_id) VALUES (?, ?, ?)", 
                b.getSeatNumber(), b.getPassengerId(), b.getFlightId());
    }
    
    public int[] saveAll(List<BoardingPass> passes) {
        List<Object[]> batch = passes.stream()
                .map(b -> new Object[]{b.getSeatNumber(), b.getPassengerId(), b.getFlightId()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO boarding_passes (seat_number, passenger_id, flight_id) VALUES (?, ?, ?)", batch);
    }

    public int update(int id, BoardingPass b) {
        return jdbcTemplate.update("UPDATE boarding_passes SET seat_number = ?, passenger_id = ?, flight_id = ? WHERE id = ?", 
                b.getSeatNumber(), b.getPassengerId(), b.getFlightId(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM boarding_passes WHERE id = ?", id);
    }
}