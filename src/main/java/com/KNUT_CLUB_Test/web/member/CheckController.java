package com.KNUT_CLUB_Test.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CheckController {

    @GetMapping("/check")
    public String goCheck() {
        return "check";
    }

    @GetMapping("/check/join")
    public String doCheck() {
        return "join";
    }
}
