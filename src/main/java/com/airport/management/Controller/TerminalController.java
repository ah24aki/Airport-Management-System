package com.airport.management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.management.Model.Terminal;
import com.airport.management.Service.TerminalService;

@CrossOrigin
@RestController
@RequestMapping("/terminals")
public class TerminalController {

    private final TerminalService terminalService;

    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping
    public List<Terminal> getAllTerminals() {
        return terminalService.getAllTerminals();
    }

    @PostMapping
    public String saveTerminal(@RequestBody Terminal terminal) {
        terminalService.saveTerminal(terminal);
        return "Terminal added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllTerminals(@RequestBody List<Terminal> terminals) {
        terminalService.saveAllTerminals(terminals);
        return "Successfully added " + terminals.size() + " terminals using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateTerminal(@PathVariable int id, @RequestBody Terminal terminal) {
        terminalService.updateTerminal(id, terminal);
        return "Terminal updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteTerminal(@PathVariable int id) {
        terminalService.deleteTerminal(id);
        return "Terminal deleted successfully!";
    }
}