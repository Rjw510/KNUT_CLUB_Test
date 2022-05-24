package com.KNUT_CLUB_Test.web.login;

import com.KNUT_CLUB_Test.domain.login.LoginService;
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

    @PostMapping("/")
    public String doLogin(@RequestParam("studentID") String id, @RequestParam("password") String pw,
                          @RequestParam("authority") int authority, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String login = "Logout";

        if (id.isEmpty()) {
            login = "Login";
        }

        // 학번 정보 저장
        session.setAttribute("login", login);
        session.setAttribute("id", id);
        session.setAttribute("authority", authority);

        LoginService service = new LoginService();
        int check = service.LoginCheck(id, pw);

        if (check == 1 && authority == 2) {
            return "index/adminIndex";
        }
        else if (check == 1 && authority == 1) {
            return "index/index";
        }
        else {
            return "redirect:/login";
        }
    }
}