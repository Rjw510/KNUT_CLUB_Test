package com.KNUT_CLUB_Test.domain.eventsrvice;


import lombok.Getter;
import lombok.Setter;

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
    private String date;
    private String img;

    public Event(int num, String name, String date, String img) {
        this.num = num;
        this.name = name;
        this.date = date;
        this.img = img;
    }

    /* eventDetail */
    public Event(String name, String introduce, String promotion, String img) {
        this.name = name;
        this.introduce = introduce;
        this.promotion = promotion;
        this.img = img;
    }
}
