package com.KNUT_CLUB_Test.web.login;

import com.KNUT_CLUB_Test.domain.login.LoginService;
import com.KNUT_CLUB_Test.domain.member.Member;
import com.KNUT_CLUB_Test.domain.member.MemberService;
import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request) {

        HttpSession session = request.getSession();

        String login = "Login";
        session.setAttribute("login", login);

        return "login";
    }

    @GetMapping("/logout")
    public String goLogout(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        session.invalidate();

        NoticeService noticeService = new NoticeService();
        List<Notice> noticeList = noticeService.getNoticeList();
        List<Notice> boardList = noticeService.getBoardList();

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        return "index/index";
    }

    @PostMapping("/")
    public String doLogin(@RequestParam("studentID") String id, @RequestParam("password") String pw,
                          @RequestParam("authority") int authority, HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        // 학번 정보 저장
        session.setAttribute("id", id);
        session.setAttribute("authority", authority);

        String state = (String) session.getAttribute("id");
        String grade = String.valueOf(session.getAttribute("authority"));



        session.setAttribute("state", state);

        LoginService service = new LoginService();
        MemberService memberService = new MemberService();
        NoticeService noticeService = new NoticeService();
        List<Member> profile = memberService.getMemberProfile(state);
        String name = memberService.getMemberName(id);
        String club = memberService.getMemberClub(id);



        int check = service.LoginCheck(id, pw);
        List<Notice> noticeList = noticeService.getNoticeList();
        List<Notice> boardList = noticeService.getBoardList();

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        session.setAttribute("authority", grade);
        session.setAttribute("profile", profile);
        session.setAttribute("name", name);
        session.setAttribute("club", club);


        if (check == 1) {
            return "index/index";
        }
        else {
            return "redirect:/login";
        }
    }
}