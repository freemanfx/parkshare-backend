package fii.offer.api;

import java.util.Date;

public class Booking {

    private Long userId;

    private Date time;

    private Booking(){
    }

    public Booking(Long userId) {
        this.userId = userId;
        this.time = new Date();
    }

    public Long getUserId() {
        return userId;
    }

    public Date getTime() {
        return time;
    }
}
