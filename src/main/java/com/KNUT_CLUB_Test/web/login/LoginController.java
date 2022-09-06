package com.KNUT_CLUB_Test.web.login;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.service.MemberService;
import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import com.KNUT_CLUB_Test.domain.noticeservice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final NoticeService noticeService;

    @GetMapping
    public String goLogin(Model model) {
        model.addAttribute("login", new Member());
        return "/sign/login";
    }

    @GetMapping("/logout")
    public String goLogout(HttpServletRequest request,
                           Model model) {

        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }

    @PostMapping
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response,
                          @ModelAttribute("login") Member member,
                          Model model) throws IOException {

        log.info("학번 : {}", member.getStudentID());
        log.info("비밀번호 : {}", member.getPassword());

        String name = memberService.getMemberName(member.getStudentID());
        String club = memberService.getMemberClub(member.getStudentID());
        String grade = memberService.getMemberGrade(member.getStudentID());

        log.info("권한 : {}", grade);

        String loginCheck = memberService.Login(member);
        List<Notice> noticeList = noticeService.getNoticeSelect();
        List<Notice> boardList = noticeService.getBoardSelect();

        /* authority */
        if (grade.equals("관리자") || grade.equals("회장") || grade.equals("부회장")) {
            grade = "admin";
        }
        else {
            grade = "user";
        }

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        /* session */
        HttpSession session = request.getSession();
        session.setAttribute("studentID", member.getStudentID());
        session.setAttribute("grade", grade);
        session.setAttribute("name", name);
        session.setAttribute("club", club);

        if (loginCheck.equals(member.getStudentID())) {
            model.addAttribute("url", "/");
            return "/alert";
        }
        else {
            model.addAttribute("message", "아이디 또는 패스워드가 잘못되었습니다");
            model.addAttribute("url", "/login");
            return "/alert";
        }
    }
}