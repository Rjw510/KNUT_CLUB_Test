package com.KNUT_CLUB_Test.web.notice;


import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import com.KNUT_CLUB_Test.domain.noticeservice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String goNotice(@RequestParam(value = "select", required = false) String field_,
                           @RequestParam(value = "word", required = false) String query_,
                           @RequestParam(value = "p", required = false) String page_,
                           HttpSession session,
                           Model model) {

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;
        
        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);


        List<Notice> noticeList = noticeService.getNoticeList(field, query, page);
        int count = noticeService.getNoticeCount(field, query);
        int startNum = page - (page - 1) % 5;
        int lastNum = (int) Math.ceil(count / 10);

        if (count % 10 != 0)
            lastNum = lastNum + 1;

        String admin = (String) session.getAttribute("admin");
        session.setAttribute("admin", admin);

        model.addAttribute("startNum", startNum);
        model.addAttribute("lastNum", lastNum);
        model.addAttribute("noticeList", noticeList);



        return "notice/notice";
    }

    @GetMapping("/notice/detail")
    public String goNoticeDetail(@RequestParam("num") int num,
                                 HttpSession session,
                                 Model model) {

//        String studentID = (String) session.getAttribute("id");

        List<Notice> list = noticeService.getNoticeDetail(num);
        noticeService.updateViews(num);

        model.addAttribute("noticeList", list);
//        model.addAttribute("studentID", studentID);

        return "notice/detail/noticeDetail";
    }

    @GetMapping("/notice/update")
    public String goNoticeUpdate(@RequestParam("num") int num,
                                 Model model) {

        List<Notice> noticeUpdate = noticeService.getNoticeDetail(num);
        model.addAttribute("noticeUpdate", noticeUpdate);

        return "/notice/update/noticeUpdate";
    }

    @PostMapping("/notice/update")
    public String doNoticeUpdate(@RequestParam("content") String content,
                                 @RequestParam("num") int num,
                                 Model model) {

        noticeService.getNoticeUpdate(content, num);
        return "redirect:/notice";
    }


    @PostMapping("/notice/noticeDetail")
    public String delNoticeDetail(@RequestParam("del_num") int num) {
        noticeService.delNotice(num);
        return "redirect:/notice";
    }

    @GetMapping("/notice/noticeWrite")
    public String goNoticeWrite() {
        return "notice/write/noticeWrite";
    }

    /* 공지사항 글쓰기 */  // 텍스트는 가능하지만 사진이 들어가면 전송 불가
    @PostMapping("/notice/noticeWrite")
    public String doNoticeWrite(@RequestParam("title") String title,
                                @RequestParam("writer") String writer,
                                @RequestParam("content") String content,
                                Model model) {

        List<Notice> noticeWrite = noticeService.writeNotice(title, writer, content);
        model.addAttribute("noticeWrite", noticeWrite);

        return "redirect:/notice";
    }

    @PostMapping("/delNotice")
    public String delNotice(@RequestParam("del_id") String[] delIds) {

        int[] ids = new int[delIds.length];

        for (int i = 0; i < delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = noticeService.delNoticeAll(ids);

        return "redirect:/notice";
    }

    @GetMapping("/board")
    public String goBoard(@RequestParam(value = "select", required = false) String field_,
                          @RequestParam(value = "word", required = false) String query_,
                          @RequestParam(value = "p", required = false) String page_,
                          Model model) {

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        List<Notice> boardList = noticeService.getBoardList(field, query, page);
        int count = noticeService.getBoardCount(field, query);
        int startNum = page - (page - 1) % 5;
        int lastNum = (int) Math.ceil(count / 10);

        if (count % 10 != 0)
            lastNum = lastNum + 1;

        model.addAttribute("startNum", startNum);
        model.addAttribute("lastNum", lastNum);
        model.addAttribute("boardList", boardList);

        return "notice/board";
    }

    @GetMapping("/board/detail")
    public String goBoardDetail(@RequestParam("num") int num,
                                HttpSession session,
                                Model model) {
        String studentID = (String) session.getAttribute("studentID");

        List<Notice> list = noticeService.getBoardDetail(num);
        noticeService.updateViews(num);

        model.addAttribute("boardList", list);
        model.addAttribute("studentID", studentID);

        return "notice/detail/boardDetail";
    }

    @GetMapping("/board/update")
    public String goBoardUpdate(@RequestParam("num") int num,
                                 Model model) {

        List<Notice> boardUpdate = noticeService.getBoardDetail(num);
        model.addAttribute("boardUpdate", boardUpdate);

        return "/notice/update/boardUpdate";
    }

        @PostMapping("/board/update")
    public String doBoardUpdate(@RequestParam("content") String content,
                                 @RequestParam("num") int num,
                                 Model model) {

        noticeService.getBoardUpdate(content, num);
        return "redirect:/board";
    }

    @PostMapping("/board/boardDetail")
    public String delBoardDetail(@RequestParam("del_num") int num) {
        noticeService.delBoard(num);
        return "redirect:/board";
    }

    @GetMapping("/board/boardWrite")
    public String goBoardWrite() {
        return "notice/write/boardWrite";
    }

    @PostMapping("/board/boardWrite")
    public String doBoardeWrite(@RequestParam("title") String title,
                                @RequestParam("writer") String writer,
                                @RequestParam("content") String content,
                                Model model) {

        List<Notice> boardWrite = noticeService.writeBoard(title, writer, content);
        model.addAttribute("boardWrite", boardWrite);

        return "redirect:/board";
    }

    @PostMapping("/board/delBoard")
    public String delBoard(@RequestParam("del_id") String[] delIds) {

        int[] ids = new int[delIds.length];

        for (int i = 0; i < delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = noticeService.delBoardAll(ids);

        return "redirect:/board";
    }
}
