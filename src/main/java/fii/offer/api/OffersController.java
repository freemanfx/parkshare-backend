package fii.offer.api;

import fii.offer.Offer;
import fii.offer.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/offers", produces = "application/json")
public class OffersController {

    @Autowired
    private OffersService offersService;

    @PostMapping(consumes = "application/json")
    public void addOffer(@RequestBody OfferDTO offerDTO) {
        offersService.save(offerDTO.toEntity());
    }

    @PostMapping("/book/{offerId}/{userId}")
    public void bookOffer(@PathVariable("offerId") Long offerId, @PathVariable("userId") Long userId) {
        offersService.bookOffer(offerId, userId);
    }

    @PostMapping("/unbook/{offerId}")
    public void bookOffer(@PathVariable("offerId") Long offerId) {
        offersService.unbookOffer(offerId);
    }

    @GetMapping("/bounds/{swLat}/{swLong}/{neLat}/{neLong}")
    public List<Offer> getOffersByBounds(@PathVariable("swLat") double southWestLatitude,
                                         @PathVariable("swLong") double southWestLongitude,
                                         @PathVariable("neLat") double northEastLatitude,
                                         @PathVariable("neLong") double northEastLongitude) {
        return offersService.findByBounds(southWestLatitude, southWestLongitude, northEastLatitude, northEastLongitude);
    }

    @GetMapping("/parking/{parkingId}")
    public List<Offer> getOffersByParkingId(@PathVariable Long parkingId) {
        return offersService.getByParkingId(parkingId);
    }
}
