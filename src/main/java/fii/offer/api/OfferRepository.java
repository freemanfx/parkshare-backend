package fii.offer.api;

import fii.offer.Offer;
import fii.parking.Parking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long> {
    List<Offer> findOfferByParking(Parking parking);

    @Query("SELECT o from Offer o WHERE o.booking.userId is NULL" +
            " AND o.validity.end > CURRENT_TIMESTAMP" +
            " ORDER by o.validity DESC"
    )
    List<Offer> findByBounds(double southWestLatitude, double southWestLongitude, double neLatitude, double neLongitude);
}
