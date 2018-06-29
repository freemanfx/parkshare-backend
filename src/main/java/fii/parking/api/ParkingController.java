package fii.parking.api;

import fii.parking.Parking;
import fii.parking.ParkingMapper;
import fii.parking.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/parking", produces = "application/json")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingMapper parkingMapper;

    @GetMapping(value = "/user/{userId}")
    public List<ParkingDTO> getParkingsByUserId(@PathVariable("userId") Long userId) {
        List<Parking> parkings = parkingService.findByUserId(userId);
        return parkings.stream().map(ParkingDTO::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody ParkingDTO parkingDTO) {
        parkingService.save(parkingMapper.toEntity(parkingDTO));
    }

}
