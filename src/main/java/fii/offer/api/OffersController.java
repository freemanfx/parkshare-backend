package fii.offer.api;

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
    public List<OfferDTO> getOffers(@PathVariable("swLat") double southWestLatitude,
                                    @PathVariable("swLong") double southWestLongitude,
                                    @PathVariable("neLat") double neLatitude,
                                    @PathVariable("neLong") double neLongitude) {
        return offersService.findByBounds(southWestLatitude, southWestLongitude, neLatitude, neLongitude);
    }


    @PostMapping(value = "/", consumes = "application/json")
    public void save(@RequestBody OfferDTO offerDTO) {
        offersService.save(offerDTO.toEntity());
    }

}
