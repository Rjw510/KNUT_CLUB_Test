package com.KNUT_CLUB_Test.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CheckController {

    @GetMapping("/check")
    public String goCheck() {
        return "check";
    }

}
