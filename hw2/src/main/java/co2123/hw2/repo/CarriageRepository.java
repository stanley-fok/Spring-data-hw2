package co2123.hw2.repo;

import java.util.List;
import co2123.hw2.model.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarriageRepository extends JpaRepository<Carriage, String> {

    List<Carriage> findByDescription(String description);
}
