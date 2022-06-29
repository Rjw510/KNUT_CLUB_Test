package com.KNUT_CLUB_Test.web.club;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Club {
    private int num;
    private String campus;
    private String type;
    private String name;
    private String activity;
    private String introduce;
    private String promotion;
    private String img;

    public Club(int num, String campus, String type, String name, String activity,
                String introduce, String promotion, String img) {
        this.num = num;
        this.campus = campus;
        this.type = type;
        this.name = name;
        this.activity = activity;
        this.introduce = introduce;
        this.promotion = promotion;
        this.img = img;
    }
}
