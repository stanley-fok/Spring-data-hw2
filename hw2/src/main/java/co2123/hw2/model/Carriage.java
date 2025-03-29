package co2123.hw2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Carriage {
    @Id
    private String description;

    @ManyToMany(mappedBy = "carriages")
    private List<Train> trains;

    @OneToMany(mappedBy = "carriage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Seat> seats;

    @OneToOne
    private Seat comfiest;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Seat getComfiest() {
        return comfiest;
    }

    public void setComfiest(Seat comfiest) {
        this.comfiest = comfiest;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setCarriage(this);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.setCarriage(null);
    }

    @Override
    public String toString() {
        return "description='" + description + '\'' +
                ", seats=" + (seats != null ? seats.size() : 0) +
                ", comfiest=" + (comfiest != null ? comfiest.getIdentifier() : "null");
    }
}
