package fii.offer.api;

import fii.offer.Validity;

import java.util.Date;

public class ValidityDTO {
    private Date start;
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Validity toEntity() {
        Validity validity = new Validity();
        validity.setStart(getStart());
        validity.setEnd(getEnd());
        return validity;
    }
}
