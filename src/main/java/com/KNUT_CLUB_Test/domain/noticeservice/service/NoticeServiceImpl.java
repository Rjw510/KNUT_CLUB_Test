package com.KNUT_CLUB_Test.domain.noticeservice.service;

import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import com.KNUT_CLUB_Test.domain.noticeservice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;

    @Override
    public List<Notice> getNoticeSelect() {
        return noticeRepository.getNoticeSelect();
    }

    @Override
    public List<Notice> getBoardSelect() {
        return noticeRepository.getBoardSelect();
    }

    @Override
    public List<Notice> getNoticeList(String field, String query, int page) {
        return noticeRepository.getNoticeList(field, query, page);
    }

    @Override
    public List<Notice> getBoardList(String field, String query, int page) {
        return noticeRepository.getBoardList(field, query, page);
    }

    @Override
    public int getNoticeCount(String field, String query) {
        return noticeRepository.getNoticeCount(field, query);
    }

    @Override
    public int getBoardCount(String field, String query) {
        return noticeRepository.getBoardCount(field, query);
    }

    @Override
    public List<Notice> getNoticeDetail(int num) {
        return noticeRepository.getNoticeDetail(num);
    }

    @Override
    public List<Notice> getBoardDetail(int num) {
        return noticeRepository.getBoardDetail(num);
    }

    @Override
    public List<Notice> writeNotice(String title, String writer, String content) {
        return noticeRepository.writeNotice(title, writer, content);
    }

    @Override
    public List<Notice> writeBoard(String title, String writer, String content) {
        return noticeRepository.writeBoard(title, writer, content);
    }

    @Override
    public void updateViews(int num) {
        noticeRepository.updateViews(num);
    }

    @Override
    public int delNoticeAll(int[] ids) {
        return noticeRepository.delNoticeAll(ids);
    }

    @Override
    public int delBoardAll(int[] ids) {
        return noticeRepository.delBoardAll(ids);
    }

    @Override
    public void delNotice(int num) {
        noticeRepository.delNotice(num);
    }

    @Override
    public void delBoard(int num) {
        noticeRepository.delBoard(num);
    }

    @Override
    public void getNoticeUpdate(String content, int num) {
        noticeRepository.getNoticeUpdate(content, num);
    }

    @Override
    public void getBoardUpdate(String content, int num) {
        noticeRepository.getBoardUpdate(content, num);
    }
}
