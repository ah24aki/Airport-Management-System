package com.airport.management.Service;

import com.airport.management.Model.Passenger;
import com.airport.management.Repository.PassengerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService {

	private final PassengerRepository passengerRepository;

	public PassengerService(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	private void validatePassenger(Passenger passenger) {
		if (passenger.getFirstName() == null || passenger.getLastName() == null
				|| passenger.getPassportNumber() == null) {
			throw new IllegalArgumentException("Error: Passenger data cannot be null or empty!");
		}

		if (passenger.getFirstName().matches(".*\\d.*") || passenger.getLastName().matches(".*\\d.*")) {
			throw new IllegalArgumentException("Error: First name and last name cannot contain numbers!");
		}

		int passportLength = passenger.getPassportNumber().length();
		if (passportLength < 6 || passportLength > 9) {
			throw new IllegalArgumentException("Error: Passport number must be between 6 and 9 characters!");
		}
	}

	public List<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}

	public void savePassenger(Passenger passenger) {
		validatePassenger(passenger);
		passengerRepository.save(passenger);
	}

	public void saveAllPassengers(List<Passenger> passengers) {
         for (Passenger p : passengers) {
            validatePassenger(p);  
        }
        passengerRepository.saveAll(passengers);
    }

	public void updatePassenger(int id, Passenger passenger) {
		validatePassenger(passenger);
		passengerRepository.update(id, passenger);
	}

	public void deletePassenger(int id) {
		passengerRepository.deleteById(id);
	}
}