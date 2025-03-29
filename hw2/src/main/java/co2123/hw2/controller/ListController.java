package co2123.hw2.controller;

import co2123.hw2.model.Carriage;
import co2123.hw2.model.Seat;
import co2123.hw2.model.Train;
import co2123.hw2.repo.CarriageRepository;
import co2123.hw2.repo.SeatRepository;
import co2123.hw2.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListController {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CarriageRepository carriageRepository;

    @Autowired
    private SeatRepository seatRepository;


    @GetMapping("/listTrain")
    public String listTrains(Model model) {
        List<Train> trains = trainRepository.findAll();
        model.addAttribute("data", trains);
        model.addAttribute("type", "train");
        return "list";
    }


    @GetMapping("/listCarriage")
    public String listCarriages(Model model) {
        List<Carriage> carriages = carriageRepository.findAll();
        model.addAttribute("data", carriages);
        model.addAttribute("type", "carriage");
        return "list";
    }


    @GetMapping("/listSeat")
    public String listSeats(Model model) {
        List<Seat> seats = seatRepository.findAll();
        model.addAttribute("data", seats);
        model.addAttribute("type", "seat");
        return "list";
    }
}
