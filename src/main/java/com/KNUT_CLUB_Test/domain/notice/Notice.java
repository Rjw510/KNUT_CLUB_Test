package com.KNUT_CLUB_Test.domain.notice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@RequiredArgsConstructor
public class Notice {
    private int n;
    private int num;
    private String title;
    private String writer;
    private Date date;
    private String content;
    private int views;

    /* noticeWrite */
//    public Notice(String title, String writer, String content) {
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//    }

    /* notice */
    public Notice(int n, int num, String title, String writer, Date date, int views) {
        this.n = n;
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.views = views;
    }

    /* noticeDetail */
    public Notice(String title, String writer, Date date, String content) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
    }
}
