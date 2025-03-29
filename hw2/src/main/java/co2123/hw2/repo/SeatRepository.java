package co2123.hw2.repo;

import java.util.List;
import co2123.hw2.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findByFee(int fee); 
}
