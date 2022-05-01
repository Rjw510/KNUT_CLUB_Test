package com.KNUT_CLUB_Test.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FindController {

    @GetMapping("/find")
    public String goFind() {
        return "find";
    }
}
