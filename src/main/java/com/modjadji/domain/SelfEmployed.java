package com.modjadji.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@DiscriminatorValue("self_employed")
public class SelfEmployed extends Person {

    private int daysLayingOnTheBeach;

    public SelfEmployed() {
        super();
    }

    public SelfEmployed(String idNumber, String name, String surname, int daysLayingOnTheBeach) {
        super(idNumber, name, surname);
        this.daysLayingOnTheBeach = daysLayingOnTheBeach;
    }

    public int getDaysLayingOnTheBeach() {
        return daysLayingOnTheBeach;
    }

    public void setDaysLayingOnTheBeach(int daysLayingOnTheBeach) {
        this.daysLayingOnTheBeach = daysLayingOnTheBeach;
    }
}
