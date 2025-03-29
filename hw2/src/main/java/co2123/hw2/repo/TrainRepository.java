package co2123.hw2.repo;

import co2123.hw2.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {

    List<Train> findByDescription(String description);

    List<Train> findBySmallest_Description(String description);
}
