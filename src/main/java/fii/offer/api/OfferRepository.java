package fii.offer.api;

import fii.offer.Offer;
import fii.parking.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long> {
    List<Offer> findOfferByParking(Parking parking);
}
