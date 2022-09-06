package com.KNUT_CLUB_Test.domain.noticeservice.service;

import com.KNUT_CLUB_Test.domain.noticeservice.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNoticeSelect();

    List<Notice> getBoardSelect();

    List<Notice> getNoticeList(String field, String query, int page);

    List<Notice> getBoardList(String field, String query, int page);

    int getNoticeCount(String field, String query);

    int getBoardCount(String field, String query);

    List<Notice> getNoticeDetail(int num);

    List<Notice> getBoardDetail(int num);

    List<Notice> writeNotice(String title, String writer, String content);

    List<Notice> writeBoard(String title, String writer, String content);

    void updateViews(int num);

    int delNoticeAll(int[] ids);

    int delBoardAll(int[] ids);

    void delNotice(int num);

    void delBoard(int num);

    void getNoticeUpdate(String content, int num);

    void getBoardUpdate(String content, int num);
}
