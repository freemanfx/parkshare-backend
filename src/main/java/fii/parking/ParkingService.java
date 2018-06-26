package fii.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;


    public void save(Parking parking) {
        parkingRepository.save(parking);
    }


    public List<Parking> findByUserId(Long userId) {
        return parkingRepository.findParkingByUser_Id(userId);
    }
}
