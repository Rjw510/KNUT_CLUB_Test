package com.KNUT_CLUB_Test.web.index;

import com.KNUT_CLUB_Test.domain.login.Login;
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
        String authority = String.valueOf(session.getAttribute("authority"));

        NoticeService noticeService = new NoticeService();
        List<Notice> noticeList = noticeService.getNoticeList();
        List<Notice> boardList = noticeService.getBoardList();

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        session.setAttribute("state", state);
        session.setAttribute("authority", authority);

        return "index/index";
    }

    /*@GetMapping("/adminIndex")
    public String goAdminIndex(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        String login = "Login";
        session.setAttribute("login", login);

        return "index/adminIndex";
    }*/

  /*  @GetMapping("/")
    public String goMain(HttpServletRequest request, Model model) {
        String login = "Logout";

        if (id.isEmpty()) {
            login = "Login";
        }

        return "index/index";
    }*/
}
