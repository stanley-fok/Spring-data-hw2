package co2123.hw2;

import co2123.hw2.model.*;
import co2123.hw2.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CarriageRepository carriageRepository;

    @Autowired
    private SeatRepository seatRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Seat seat1 = new Seat();
        seat1.setIdentifier(1);
        seat1.setFee(100);

        Seat seat2 = new Seat();
        seat2.setIdentifier(2);
        seat2.setFee(150);

        seatRepository.save(seat1);
        seatRepository.save(seat2);

        Carriage carriage1 = new Carriage();
        carriage1.setDescription("High-end Carriage");
        carriage1.setSeats(List.of(seat1, seat2));
        carriage1.setComfiest(seat2);

        carriageRepository.save(carriage1);


        Train train = new Train();
        train.setId(101);
        train.setDescription("Express Train");
        train.setCarriages(List.of(carriage1));


        train.setSmallest(carriage1);

        trainRepository.save(train);

        System.out.println("Saved Train: " + trainRepository.findById(train.getId()).orElse(null));
        System.out.println("Saved Carriage: " + carriageRepository.findByDescription("High-end Carriage"));
        System.out.println("Saved Seats: " + seatRepository.findByFee(100));
    }
}
