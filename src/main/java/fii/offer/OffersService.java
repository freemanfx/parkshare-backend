package fii.offer;

import fii.offer.api.OfferDTO;
import fii.offer.api.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersService {
    @Autowired
    private OfferRepository offerRepository;

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public List<OfferDTO> findByBounds(double southWestLatitude, double southWestLongitude, double neLatitude, double neLongitude) {
        return null;
    }
}
