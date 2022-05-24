package com.KNUT_CLUB_Test.domain.notice;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Notice {
    private int n;
    private int num;
    private String title;
    private String writer;
    private Date date;
    private String content;
    private String file;

    /* notice */
    public Notice(int n, int num, String title, String writer, Date date) {
        this.n = n;
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.date = date;
    }


    /* noticeDetail */
    public Notice(String title, String writer, Date date, String content, String file) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
        this.file = file;
    }
}
