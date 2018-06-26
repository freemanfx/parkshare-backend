package fii.offer.api;

import fii.offer.Offer;
import fii.parking.api.ParkingDTO;

public class OfferDTO {
    private Long id;

    private ParkingDTO parking;

    private ValidityDTO validity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingDTO getParking() {
        return parking;
    }

    public void setParking(ParkingDTO parking) {
        this.parking = parking;
    }

    public ValidityDTO getValidity() {
        return validity;
    }

    public void setValidity(ValidityDTO validity) {
        this.validity = validity;
    }

    public Offer toEntity() {
        Offer offer = new Offer();
        offer.setId(getId());
        offer.setParking(getParking().toEntity());
        offer.setValidity(getValidity().toEntity());
        return offer;
    }

}
