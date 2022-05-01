package com.KNUT_CLUB_Test.web.login;

import com.KNUT_CLUB_Test.domain.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String goLogin() {
        return "login";
    }

    @PostMapping("/")
    public String doLogin(@RequestParam("studentID") String id, @RequestParam("password") String pw,
                          @RequestParam("authority") int authority) {

        LoginService service = new LoginService();
        int check = service.LoginCheck(id, pw);

        if (check == 1 && authority == 2) {
            return "/adminIndex";
        }
        else if (check == 1 && authority == 1) {
            return "/index";
        }
        else {
            return "redirect:/login";
        }
    }
}
