package fii.offer;

import fii.offer.api.OfferRepository;
import fii.parking.Parking;
import fii.parking.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffersService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ParkingRepository parkingRepository;

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public List<Offer> findByBounds(double southWestLatitude, double southWestLongitude, double neLatitude, double neLongitude) {
        //TODO: filter by params
        List<Offer> offers = offerRepository.findByBounds(southWestLatitude, southWestLongitude, neLatitude, neLongitude);
        return offers;
    }

    public List<Offer> getByParkingId(Long parkingId) {
        Optional<Parking> parking = parkingRepository.findById(parkingId);

        return parking
                .map(offerRepository::findOfferByParking)
                .orElseThrow(() -> new RuntimeException("Parking with id " + parkingId + " could not be found!"));
    }

    public void bookOffer(Long offerId, Long userId) {
        Optional<Offer> optional = offerRepository.findById(offerId);
        if (optional.isPresent()) {
            Offer offer = optional.get();
            if (offer.isBooked()) {
                throw new RuntimeException("Offer is already booked!");
            }

            offer.markAsBooked(userId);

            offerRepository.save(offer);
        }
    }

    public void unbookOffer(Long offerId) {
        Optional<Offer> optional = offerRepository.findById(offerId);
        if (optional.isPresent()) {
            Offer offer = optional.get();
            offer.markAsUnbooked();
            offerRepository.save(offer);
        }
    }
}
