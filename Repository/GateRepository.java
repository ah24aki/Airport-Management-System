package com.airport.management.Repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.airport.management.Model.Gate;

@Repository
public class GateRepository {

    private final JdbcTemplate jdbcTemplate;

    public GateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Gate> mapper = (rs, rowNum) -> {
        Gate g = new Gate();
        g.setId(rs.getInt("id"));
        g.setGateNumber(rs.getString("gate_number"));
        g.setIsAvailable(rs.getBoolean("is_available"));
        g.setTerminalId(rs.getInt("terminal_id"));
        return g;
    };

    public List<Gate> findAll() {
        return jdbcTemplate.query("SELECT * FROM gates", mapper);
    }

    public int save(Gate g) {
        return jdbcTemplate.update("INSERT INTO gates (gate_number, is_available, terminal_id) VALUES (?, ?, ?)", 
                g.getGateNumber(), g.getIsAvailable(), g.getTerminalId());
    }
    
    public int[] saveAll(List<Gate> gates) {
        List<Object[]> batch = gates.stream()
                .map(g -> new Object[]{g.getGateNumber(), g.getIsAvailable(), g.getTerminalId()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO gates (gate_number, is_available, terminal_id) VALUES (?, ?, ?)", batch);
    }

    public int update(int id, Gate g) {
        return jdbcTemplate.update("UPDATE gates SET gate_number = ?, is_available = ?, terminal_id = ? WHERE id = ?", 
                g.getGateNumber(), g.getIsAvailable(), g.getTerminalId(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM gates WHERE id = ?", id);
    }
}