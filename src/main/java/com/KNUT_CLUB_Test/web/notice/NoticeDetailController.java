package com.KNUT_CLUB_Test.web.notice;

import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeDetailController {

    @GetMapping("/notice/detail")
    public String goNoticeDetail(@RequestParam("num") int num, Model model) {
        
        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeDetail(num);

        model.addAttribute("list", list);

        return "notice/detail/noticeDetail";
    }

    @GetMapping("/board/detail")
    public String goBoardDetail(@RequestParam("num") int num, Model model) {

        NoticeService service = new NoticeService();
        List<Notice> list = service.getBoardDetail(num);

        model.addAttribute("list", list);

        return "notice/detail/boardDetail";
    }
}
