package com.KNUT_CLUB_Test.web.index;

import com.KNUT_CLUB_Test.domain.login.Login;
import com.KNUT_CLUB_Test.domain.member.Member;
import com.KNUT_CLUB_Test.domain.member.MemberService;
import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String goIndex(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String state = (String) session.getAttribute("id");
//        String authority = String.valueOf(session.getAttribute("authority"));

        NoticeService noticeService = new NoticeService();
        MemberService memberService = new MemberService();

        List<Notice> noticeList = noticeService.getNoticeList();
        List<Notice> boardList = noticeService.getBoardList();
        List<Member> profile = memberService.getMemberProfile(state);

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);
        model.addAttribute("profile", profile);

        session.setAttribute("state", state);
//        session.setAttribute("authority", authority);
//        session.setAttribute("profile", profile);

        return "index/index";
    }

    @GetMapping("/writing")
    public String goNoticeWrite() {
        return "/index/write";
    }
}
