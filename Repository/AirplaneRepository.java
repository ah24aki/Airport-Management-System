package com.airport.management.Repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.airport.management.Model.Airplane;

@Repository
public class AirplaneRepository {

    private final JdbcTemplate jdbcTemplate;

    public AirplaneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Airplane> mapper = (rs, rowNum) -> {
        Airplane a = new Airplane();
        a.setId(rs.getInt("id"));
        a.setModelName(rs.getString("model_name"));
        a.setCapacity(rs.getInt("capacity"));
        a.setAirlineId(rs.getInt("airline_id"));
        return a;
    };

    public List<Airplane> findAll() {
        return jdbcTemplate.query("SELECT * FROM airplanes", mapper);
    }

    public int save(Airplane a) {
        return jdbcTemplate.update("INSERT INTO airplanes (model_name, capacity, airline_id) VALUES (?, ?, ?)", 
                a.getModelName(), a.getCapacity(), a.getAirlineId());
    }
    
    public int[] saveAll(List<Airplane> airplanes) {
        List<Object[]> batch = airplanes.stream()
                .map(a -> new Object[]{a.getModelName(), a.getCapacity(), a.getAirlineId()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO airplanes (model_name, capacity, airline_id) VALUES (?, ?, ?)", batch);
    }

    public int update(int id, Airplane a) {
        return jdbcTemplate.update("UPDATE airplanes SET model_name = ?, capacity = ?, airline_id = ? WHERE id = ?", 
                a.getModelName(), a.getCapacity(), a.getAirlineId(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM airplanes WHERE id = ?", id);
    }
}