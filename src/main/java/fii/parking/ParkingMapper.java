package fii.parking;

import fii.parking.api.ParkingDTO;
import fii.user.User;
import fii.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParkingMapper {

    @Autowired
    private UserRepository userRepository;

    public Parking toEntity(ParkingDTO parkingDTO) {
        Optional<User> user = userRepository.findById(parkingDTO.getUserId());

        if (user.isPresent()) {
            Parking parking = new Parking();
            parking.setName(parkingDTO.getName());
            parking.setLatitude(parkingDTO.getLatitude());
            parking.setLongitude(parkingDTO.getLongitude());
            parking.setUser(user.get());
            return parking;
        } else {
            throw new RuntimeException("User with id " + parkingDTO.getId() + " could not be found!");
        }
    }
}
