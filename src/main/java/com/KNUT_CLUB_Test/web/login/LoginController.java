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
                          HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        // 회원 정보 저장
        session.setAttribute("id", id);
        id = (String) session.getAttribute("id");

        // 서비스 생성
        LoginService service = new LoginService();
        MemberService memberService = new MemberService();
        NoticeService noticeService = new NoticeService();

        String name = memberService.getMemberName(id);
        String club = memberService.getMemberClub(id);
        String authority = memberService.getMemberAuthority(id);
        String department = memberService.getMemberDepartment(id);
        String phone = memberService.getMemberPhone(id);

        int check = service.LoginCheck(id, pw);

        String grade = "";
        if (authority.equals("0") || authority.equals("1") || authority.equals("2")) {
            grade = "admin";
        }
        else {
            grade = "user";
        }

        // 공지사항 & 자유게시판
        List<Notice> noticeList = noticeService.getNoticeList();
        List<Notice> boardList = noticeService.getBoardList();

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        session.setAttribute("id", id);
        session.setAttribute("grade", grade);
        session.setAttribute("name", name);
        session.setAttribute("department", department);
        session.setAttribute("phone", phone);
        session.setAttribute("club", club);

        if (check == 1) {
            return "index/index";
        }
        else {
            return "redirect:/login";
        }
    }
}