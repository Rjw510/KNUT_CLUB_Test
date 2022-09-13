package com.KNUT_CLUB_Test.web.member;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;
import com.KNUT_CLUB_Test.domain.adminservice.service.AdminService;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.service.MemberService;
import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import com.KNUT_CLUB_Test.domain.noticeservice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/check/join")
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;
    private final NoticeService noticeService;
    private final AdminService adminService;

    /* 회원 회원가입 페이지 이동*/
    @GetMapping
    public String goJoin(Model model) {
        model.addAttribute("join", new Member());
        return "/sign/join";
    }

    /* 관리자 회원가입 페이지 이동 */
    @GetMapping("/admin")
    public String goJoinAdmin(Model model) {
        model.addAttribute("adminJoin", new Admin());
        return "/sign/joinAdmin";
    }

    /* 회원 회원가입 */
    @PostMapping()
    public String doJoin(@ModelAttribute("join") Member member,
                         @RequestParam("birth_mm") String mm,
                         @RequestParam("gender") String gender,
                         Model model) {

        log.info("회원 회원가입");
        String birth = member.getBirth_yy()+"."+mm+"."+member.getBirth_dd();

        boolean check = memberService.getJoin(member, birth, gender);
        List<Notice> noticeList = noticeService.getNoticeSelect();
        List<Notice> boardList = noticeService.getBoardSelect();

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        if (check == true) {
            model.addAttribute("message", "회원가입이 완료되었습니다.");
            model.addAttribute("url", "/index");
        }
        else {
            model.addAttribute("message", "필수 정보가 비어있습니다.");
            model.addAttribute("url", "/check/join");
        }
        return "/alert";
    }

}
