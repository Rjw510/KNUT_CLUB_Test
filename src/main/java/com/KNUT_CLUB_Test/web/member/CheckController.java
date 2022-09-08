package com.KNUT_CLUB_Test.web.member;

import com.KNUT_CLUB_Test.domain.memberservice.Check;
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

    /* 회원 약관동의 페이지 이동 */
    @GetMapping
    public String goCheck(Model model) {
        model.addAttribute("chk", new Check());
        return "/sign/check";
    }

    /* 관리자 약관동의 페이지 이동 */
    @GetMapping("/admin")
    public String goCheckAdmin(Model model) {
        model.addAttribute("chk", new Check());
        return "/sign/checkAdmin";
    }

    /* 회원 회원가입 페이지 이동*/
//    @GetMapping("/join")
//    public String goJoin(Model model) {
//        return "/sign/join";
//    }

    /* 관리자 회원가입 페이지 이동 */
//    @GetMapping("/join/admin")
//    public String goJoinAdmin(Model model) {
//        return "/sign/joinAdmin";
//    }

    /* 약관동의 */
    @PostMapping
    public String doCheck(@ModelAttribute Check chk,
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

    /* 관리자 약관동의 */
    @PostMapping("/admin")
    public String doCheckAdmin(@ModelAttribute Check chk,
                          Model model) {

        Boolean chk_1 = chk.getChk_1();
        Boolean chk_2 = chk.getChk_2();

        if (chk_1==true && chk_2==true) {
            model.addAttribute("url", "/check/join/admin");
            return "/alert";
        }
        model.addAttribute("url", "/check/admin");
        model.addAttribute("message", "이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.");
        return "/alert";
    }

}
