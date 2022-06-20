package com.KNUT_CLUB_Test.web.notice;

import com.KNUT_CLUB_Test.domain.notice.FileDto;
import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.plaf.ButtonUI;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

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
    public String goBoardWrite() {
        return "notice/write/boardWrite";
    }

    @PostMapping("/board/boardWrite")
    public String doBoardWrite(@RequestParam("title") String title, @RequestParam("writer") String writer,
                                @RequestParam("content") String content, Model model) {
        NoticeService service = new NoticeService();

        List<Notice> list = service.writeBoard(title, writer, content);
        model.addAttribute("list", list);

        return "redirect:/notice";
    }
}
