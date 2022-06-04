package com.KNUT_CLUB_Test.web.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class NoticeWriteController {

    @GetMapping("/notice/noticeWrite")
    public String goNoticeWrite() {
        return "notice/write/noticeWrite";
    }

    @GetMapping("/board/boardWrite")
    public String goBoardWrite() {
        return "notice/write/boardWrite";
    }

    @PostMapping("/upload")
    public String doNoticeWrite() {
        String uploadFolder = "C:/tools/졸업작품/KNUT_CLUB_Test/src/main/resources/static/img/sample";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        Date date = new Date();
        String str = sdf.format(date);
        String datePath = str.replace("-", File.separator);

        File uploadPath = new File(uploadFolder, datePath);

        if (uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        return ("notice/write/noticeWrite");
    }
}
