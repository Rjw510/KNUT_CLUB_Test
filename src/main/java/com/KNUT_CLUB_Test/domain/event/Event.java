package com.KNUT_CLUB_Test.domain.event;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Event {
    private int num;
    private String campus;
    private String type;
    private String name;
    private String activity;
    private String introduce;
    private String promotion;
    private Date date;
    private String img;

    public Event(int num, String name, Date date, String img) {
        this.num = num;
        this.name = name;
        this.date = date;
        this.img = img;
    }
}
