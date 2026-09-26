package com.airport.management.Service;

import com.airport.management.Model.BoardingPass;
import com.airport.management.Repository.BoardingPassRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardingPassService {

    private final BoardingPassRepository boardingPassRepository;

    public BoardingPassService(BoardingPassRepository boardingPassRepository) {
        this.boardingPassRepository = boardingPassRepository;
    }

    private void validateBoardingPass(BoardingPass boardingPass) {
        if (boardingPass.getSeatNumber() == null || boardingPass.getSeatNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Seat number cannot be empty!");
        }
        if (boardingPass.getPassengerId() <= 0) {
            throw new IllegalArgumentException("Error: Invalid Passenger ID! Must be greater than zero.");
        }
        if (boardingPass.getFlightId() <= 0) {
            throw new IllegalArgumentException("Error: Invalid Flight ID! Must be greater than zero.");
        }
    }

    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassRepository.findAll();
    }

    public void saveBoardingPass(BoardingPass boardingPass) {
        validateBoardingPass(boardingPass);
        boardingPassRepository.save(boardingPass);
    }

    public void saveAllBoardingPasses(List<BoardingPass> boardingPasses) {
        for (BoardingPass bp : boardingPasses) {
            validateBoardingPass(bp);
        }
        boardingPassRepository.saveAll(boardingPasses);
    }

    public void updateBoardingPass(int id, BoardingPass boardingPass) {
        validateBoardingPass(boardingPass); 
        boardingPassRepository.update(id, boardingPass);
    }

    public void deleteBoardingPass(int id) {
        boardingPassRepository.deleteById(id);
    }
}