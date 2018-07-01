package fii.config;

import fii.parking.Parking;
import fii.parking.ParkingService;
import fii.user.User;
import fii.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitDataService {

    @Autowired
    private UserService userService;

    @Autowired
    private ParkingService parkingService;

    @PostConstruct
    public void init() {
        User user = userService.findByUsername("proprietar");

        if (user == null) {

            User proprietar = new User("proprietar", "pass");

            Parking parking1 = new Parking();
            parking1.setName("Piata Victoriei");
            parking1.setLatitude(44.4522282924181);
            parking1.setLongitude(26.08564507216215);
            parking1.setUser(proprietar);

            Parking parking2 = new Parking();
            parking2.setName("Pasaj Piata Victoriei");
            parking2.setLatitude(44.45212657635696);
            parking2.setLongitude(26.08734760433435);
            parking2.setUser(proprietar);

            Parking parking3 = new Parking();
            parking3.setName("Iancu de Hunedoara");
            parking3.setLatitude(44.452516);
            parking3.setLongitude(26.089702);
            parking3.setUser(proprietar);

            userService.save(proprietar);
            parkingService.save(parking1);
            parkingService.save(parking2);
            parkingService.save(parking3);
        }

        User sofer = userService.findByUsername("sofer");
        if (sofer == null) {
            sofer = new User("sofer", "pass");
            userService.save(sofer);
        }
    }
}
