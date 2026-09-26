package com.airport.management.Repository;

import com.airport.management.Model.Terminal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TerminalRepository {

    private final JdbcTemplate jdbcTemplate;

    public TerminalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Terminal> mapper = (rs, rowNum) -> {
        Terminal t = new Terminal();
        t.setId(rs.getInt("id"));
        t.setName(rs.getString("name"));
        return t;
    };

    public List<Terminal> findAll() {
        return jdbcTemplate.query("SELECT * FROM terminals", mapper);
    }

    public int save(Terminal t) {
        return jdbcTemplate.update("INSERT INTO terminals (name) VALUES (?)", t.getName());
    }

    public int[] saveAll(List<Terminal> terminals) {
        List<Object[]> batch = terminals.stream()
                .map(t -> new Object[]{t.getName()})
                .collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO terminals (name) VALUES (?)", batch);
    }

    public int update(int id, Terminal t) {
        return jdbcTemplate.update("UPDATE terminals SET name = ? WHERE id = ?", t.getName(), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM terminals WHERE id = ?", id);
    }
}