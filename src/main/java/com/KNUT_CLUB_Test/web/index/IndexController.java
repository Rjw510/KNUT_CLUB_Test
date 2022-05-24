package com.KNUT_CLUB_Test.web.index;

import com.KNUT_CLUB_Test.domain.login.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String goMain(HttpServletRequest request, Model model) {
        return "index/index";
    }

    @GetMapping("/index")
    public String goIndex(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        String authority = (String) session.getAttribute("authority");
        model.addAttribute("authority", authority);

        String login = "Login";
        session.setAttribute("login", login);


        return "index/index";
    }

    @GetMapping("/adminIndex")
    public String goAdminIndex(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        String login = "Login";
        session.setAttribute("login", login);

        return "index/adminIndex";
    }
}
