package fii.parking.api;


import fii.parking.Parking;
import fii.user.User;

public class ParkingDTO {
    private Long id;

    private String name;

    private Long userId;

    private double latitude;

    private double longitude;

    public ParkingDTO() {

    }

    public ParkingDTO(Parking parking) {
        id = parking.getId();
        latitude = parking.getLatitude();
        longitude = parking.getLongitude();
        name = parking.getName();
        userId = parking.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Parking toEntity() {
        User user = new User();

        Parking parking = new Parking();
        parking.setId(getId());
        parking.setLatitude(getLatitude());
        parking.setLongitude(getLongitude());
        parking.setUser(user);
        parking.setName(getName());
        return parking;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
