package com.KNUT_CLUB_Test.web.notice;

import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeWriteController {

    @GetMapping("/notice/noticeWrite")
    public String goNoticeWrite() {
        return "notice/write/noticeWrite";
    }

    @PostMapping("/notice/noticeWrite")
    public String doNoticeWrite(@RequestParam("title") String title, @RequestParam("writer") String writer,
                                @RequestParam("content") String content, Model model) {

        NoticeService service = new NoticeService();

        List<Notice> list = service.writeNotice(title, writer, content);
        model.addAttribute("list", list);

        return "redirect:/notice";
    }

    @GetMapping("/board/boardWrite")
    public String goBoardWrite(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String state = (String) session.getAttribute("id");

        if(state == null) {
            return "redirect:/board";
        }
        return "notice/write/boardWrite";
    }

    @PostMapping("/board/boardWrite")
    public String doBoardWrite(@RequestParam("title") String title, @RequestParam("writer") String writer,
                                @RequestParam("content") String content, Model model) {

        NoticeService service = new NoticeService();

        List<Notice> list = service.writeBoard(title, writer, content);
        model.addAttribute("list", list);

        return "redirect:/board";
    }
}
