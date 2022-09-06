package com.KNUT_CLUB_Test.web.mypage;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;

    @GetMapping
    public String goMyPage(HttpServletRequest request,
                           Model model) {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("studentID");
        List<Member> profile = memberService.getMemberProfile(studentID);

        model.addAttribute("profile", profile);

        return "/mypage/mypage";
    }

    @GetMapping("/update")
    public String goMypageUpdate(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("studentID");
        List<Member> profile = memberService.getMemberProfile(studentID);

        model.addAttribute("profile", profile);

        return "/mypage/update";
    }

    @PostMapping("/update")
    public String doMyPageUpdate(@ModelAttribute Member member) {

        memberService.getMemberUpdate(member);
        return "redirect:/mypage";
    }

    @PostMapping("/delete")
    public String doMyPageDelete(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("studentID");
        memberService.getMemberDelete(studentID);

        session.invalidate();

        return "redirect:/";
    }
}
