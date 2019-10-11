package com.modjadji.domain;

import javax.persistence.Entity;
import java.util.Set;

@Entity
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
