package com.modjadji.domain;

import java.util.List;

public class SelfEmployed extends Person {

    private int daysLayingOnTheBeach;

    public SelfEmployed(String idNumber, List<String> names, String surname, int daysLayingOnTheBeach) {
        super(idNumber, names, surname);
        this.daysLayingOnTheBeach = daysLayingOnTheBeach;
    }

    public int getDaysLayingOnTheBeach() {
        return daysLayingOnTheBeach;
    }

    public void setDaysLayingOnTheBeach(int daysLayingOnTheBeach) {
        this.daysLayingOnTheBeach = daysLayingOnTheBeach;
    }
}
