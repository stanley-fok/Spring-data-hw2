package co2123.hw2.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "train_carriage",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "carriage_description")
    )
    private List<Carriage> carriages;

    @ManyToOne
    private Carriage smallest;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public Carriage getSmallest() {
        return smallest;
    }

    public void setSmallest(Carriage smallest) {
        this.smallest = smallest;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", description='" + description + '\'' +
                ", carriages=" + (carriages != null ? carriages.stream().map(Carriage::getDescription).collect(Collectors.joining(", ")) : "none") +
                ", smallest=" + (smallest != null ? smallest.getDescription() : "null");
    }
}
