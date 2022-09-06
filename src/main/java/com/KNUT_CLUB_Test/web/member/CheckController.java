package com.KNUT_CLUB_Test.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/check")
@RequiredArgsConstructor
public class CheckController {

    @GetMapping
    public String goCheck(Model model) {
        model.addAttribute("chk", new Chk());
        return "/sign/check";
    }

    @GetMapping("/join")
    public String goJoin(Model model) {
        return "/sign/join";
    }

    @PostMapping("/join")
    public String doCheck(@ModelAttribute Chk chk,
                          Model model) {

        Boolean chk_1 = chk.getChk_1();
        Boolean chk_2 = chk.getChk_2();

        if (chk_1==true && chk_2==true) {
            model.addAttribute("url", "/check/join");
            return "/alert";
        }
        model.addAttribute("url", "/check");
        model.addAttribute("message", "이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.");
        return "/alert";
    }

}
