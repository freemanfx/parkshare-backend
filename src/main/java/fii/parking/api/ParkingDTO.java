package fii.parking.api;


import fii.parking.Parking;
import fii.user.User;
import fii.user.api.UserDTO;

public class ParkingDTO {
    private Long id;

    private String name;

    private UserDTO user;

    private double latitude;

    private double longitude;

    public ParkingDTO() {

    }

    public ParkingDTO(Parking parking) {
        id = parking.getId();
        latitude = parking.getLatitude();
        longitude = parking.getLongitude();
        name = parking.getName();
        user = new UserDTO(parking.getUser());
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
        UserDTO userDTO = getUser();
        User user = new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName());

        Parking parking = new Parking();
        parking.setId(getId());
        parking.setLatitude(getLatitude());
        parking.setLongitude(getLongitude());
        parking.setUser(user);
        parking.setName(getName());
        return parking;
    }
}
