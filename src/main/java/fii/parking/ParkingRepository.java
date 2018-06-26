package fii.parking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {
    List<Parking> findParkingByUser_Id(Long userId);
}
