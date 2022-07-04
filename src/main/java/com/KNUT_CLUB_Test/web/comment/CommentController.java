//package com.KNUT_CLUB_Test.web.comment;
//
//import com.KNUT_CLUB_Test.domain.notice.Comment;
//import com.KNUT_CLUB_Test.domain.notice.NoticeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class CommentController {
//
//    @PostMapping("/writeComment")
//    public writeComment(@RequestParam("writer") String writer, @RequestParam("content") String content,
//                        @RequestParam("date") Date date, Model model) {
//
//        NoticeService service = new NoticeService();
//
//        List<Comment> list = service.writeComment(writer, content, date);
//        model.addAttribute
//    }
//
//}
