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

import com.airport.management.Model.BoardingPass;
import com.airport.management.Service.BoardingPassService;


@CrossOrigin
@RestController
@RequestMapping("/boarding-passes")
public class BoardingPassController {

    private final BoardingPassService boardingPassService;

    public BoardingPassController(BoardingPassService boardingPassService) {
        this.boardingPassService = boardingPassService;
    }

    @GetMapping
    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassService.getAllBoardingPasses();
    }

    @PostMapping
    public String saveBoardingPass(@RequestBody BoardingPass boardingPass) {
        boardingPassService.saveBoardingPass(boardingPass);
        return "Boarding Pass added successfully!";
    }

    @PostMapping("/saveAll")
    public String saveAllBoardingPasses(@RequestBody List<BoardingPass> boardingPasses) {
        boardingPassService.saveAllBoardingPasses(boardingPasses);
        return "Successfully added " + boardingPasses.size() + " boarding passes using Batch Processing!";
    }

    @PutMapping("/{id}")
    public String updateBoardingPass(@PathVariable int id, @RequestBody BoardingPass boardingPass) {
        boardingPassService.updateBoardingPass(id, boardingPass);
        return "Boarding Pass updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteBoardingPass(@PathVariable int id) {
        boardingPassService.deleteBoardingPass(id);
        return "Boarding Pass deleted successfully!";
    }
}