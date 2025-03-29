package co2123.hw2.controller;

import co2123.hw2.model.Carriage;
import co2123.hw2.model.Seat;
import co2123.hw2.model.Train;
import co2123.hw2.repo.CarriageRepository;
import co2123.hw2.repo.SeatRepository;
import co2123.hw2.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CarriageRepository carriageRepository;

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/deleteTrain")
    public String deleteTrain(@RequestParam(name = "id", required = true) Integer id) {
        if (id == null || !trainRepository.existsById(id)) {
            return "redirect:/?error=TrainNotFound";
        }

        Train train = trainRepository.findById(id).orElse(null);
        if (train != null) {
            // Remove references to the train in associated carriages
            for (Carriage carriage : train.getCarriages()) {
                carriage.getTrains().remove(train);
                carriageRepository.save(carriage);
            }
            // Delete the train
            trainRepository.delete(train);
        }

        return "redirect:/?success=TrainDeleted";
    }

    @GetMapping("/deleteCarriage")
    public String deleteCarriage(@RequestParam(name = "description", required = true) String description) {
        if (description == null || !carriageRepository.existsById(description)) {
            return "redirect:/?error=CarriageNotFound";
        }

        Carriage carriage = carriageRepository.findById(description).orElse(null);
        if (carriage != null) {
            // Remove references to the carriage in associated trains
            for (Train train : carriage.getTrains()) {
                train.getCarriages().remove(carriage);
                trainRepository.save(train);
            }
            // Delete the carriage
            carriageRepository.delete(carriage);
        }

        return "redirect:/?success=CarriageDeleted";
    }

    @GetMapping("/deleteSeat")
    public String deleteSeat(@RequestParam(name = "identifier", required = true) Integer identifier) {
        if (identifier == null || !seatRepository.existsById(identifier)) {
            return "redirect:/?error=SeatNotFound";
        }

        Seat seat = seatRepository.findById(identifier).orElse(null);
        if (seat != null) {
            // Delete the seat
            seatRepository.delete(seat);
        }

        return "redirect:/?success=SeatDeleted";
    }
}
