package co2123.hw2.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifier;

    private int fee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carriage_description")
    private Carriage carriage;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "identifier=" + identifier +
                ", fee=" + fee;
    }
}