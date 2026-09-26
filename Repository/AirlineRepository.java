package com.airport.management.Repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.airport.management.Model.Airline;

@Repository
public class AirlineRepository {

    private final JdbcTemplate jdbcTemplate;

    public AirlineRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Airline> mapper = (rs, rowNum) -> {
        Airline a = new Airline();
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));
        a.setCode(rs.getString("code"));
        return a;
    };

    public List<Airline> findAll() {
        return jdbcTemplate.query("SELECT * FROM airlines", mapper);
    }

    public int save(Airline a) {
        return jdbcTemplate.update("INSERT INTO airlines (name, code) VALUES (?, ?)", a.getName(), a.getCode());
    }
    
    public int[] saveAll(List<Airline> airlines) {
        List<Object[]> batch = airlines.stream()
                .map(a -> new Object[]{a.getName(), a.getCode()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO airlines (name, code) VALUES (?, ?)", batch);
    }

    public int update(int id, Airline a) {
        return jdbcTemplate.update("UPDATE airlines SET name = ?, code = ? WHERE id = ?", a.getName(), a.getCode(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM airlines WHERE id = ?", id);
    }
}