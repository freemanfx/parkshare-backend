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

    @GetMapping("/bounds/{swLat}/{swLong}/{neLat}/{neLong}")
    public Iterable<Offer> getOffers(@PathVariable("swLat") double southWestLatitude,
                                     @PathVariable("swLong") double southWestLongitude,
                                     @PathVariable("neLat") double northEastLatitude,
                                     @PathVariable("neLong") double northEastLongitude) {
        return offersService.findByBounds(southWestLatitude, southWestLongitude, northEastLatitude, northEastLongitude);
    }

    @GetMapping("/parking/{parkingId}")
    public List<Offer> getOffersByParkingId(@PathVariable Long parkingId) {
        return offersService.getByParkingId(parkingId);
    }

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody OfferDTO offerDTO) {
        offersService.save(offerDTO.toEntity());
    }
}
