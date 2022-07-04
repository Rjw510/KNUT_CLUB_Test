package com.KNUT_CLUB_Test.domain.notice;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Comment {
    private int num;
    private int boardNum;
    private String writer;
    private Date date;
    private String content;

    public Comment(String writer, Date date, String content) {
        this.writer = writer;
        this.date = date;
        this.content = content;
    }
}
