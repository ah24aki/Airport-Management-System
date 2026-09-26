package com.airport.management.Service;

import com.airport.management.Model.Terminal;
import com.airport.management.Repository.TerminalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TerminalService {

    private final TerminalRepository terminalRepository;

    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    private void validateTerminal(Terminal terminal) {
        if (terminal.getName() == null || terminal.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Terminal name cannot be empty!");
        }
    }

    public List<Terminal> getAllTerminals() {
        return terminalRepository.findAll();
    }

    public void saveTerminal(Terminal terminal) {
        validateTerminal(terminal);
        terminalRepository.save(terminal);
    }

    public void saveAllTerminals(List<Terminal> terminals) {
        for (Terminal t : terminals) {
            validateTerminal(t);
        }
        terminalRepository.saveAll(terminals);
    }

    public void updateTerminal(int id, Terminal terminal) {
        validateTerminal(terminal); 
        terminalRepository.update(id, terminal);
    }

    public void deleteTerminal(int id) {
        terminalRepository.deleteById(id);
    }
}