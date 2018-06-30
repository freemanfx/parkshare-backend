package fii.offer;

import fii.offer.api.Booking;
import fii.parking.Parking;

import javax.persistence.*;

@Entity
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Parking parking;

    @Embedded
    private Validity validity;

    @Embedded
    private Booking booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    public boolean isBooked() {
        return booking != null;
    }

    public void markAsBooked(Long userId) {
        booking = new Booking(userId);
    }

    public void markAsUnbooked() {
        booking = null;
    }
}
