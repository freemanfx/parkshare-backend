package fii.offer;

import fii.offer.api.OfferDTO;
import fii.offer.api.OfferRepository;
import fii.parking.Parking;
import fii.parking.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public List<OfferDTO> findByBounds(double southWestLatitude, double southWestLongitude, double neLatitude, double neLongitude) {
        return Collections.emptyList();
    }

    public List<Offer> getByParkingId(Long parkingId) {
        Optional<Parking> parking = parkingRepository.findById(parkingId);
        if (parking.isPresent()) {
            return offerRepository.findOfferByParking(parking.get());
        } else {
            throw new RuntimeException("Parking with id " + parkingId + " could not be found!");
        }
    }
}
