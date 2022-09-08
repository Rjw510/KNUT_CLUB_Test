package com.KNUT_CLUB_Test.web.mypage;

//import com.KNUT_CLUB_Test.domain.member.Member;
//import com.KNUT_CLUB_Test.domain.member.MemberService;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.service.MemberService;

import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import com.KNUT_CLUB_Test.domain.noticeservice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;
    private final NoticeService noticeService;

    @GetMapping
    public String goMyPage(HttpSession session, Model model) {

        String studentID = (String) session.getAttribute("id");

        if (studentID == null) {
            return "/login";
        }
        else {
            List<Member> profile = memberService.getMemberProfile(studentID);
            model.addAttribute("profile", profile);
            return "/mypage/mypage";
        }
    }

    @GetMapping("/admin")
    public String goMyPageAdmin(HttpSession session, Model model) {

        String admin = (String) session.getAttribute("admin");
        String id = (String) session.getAttribute("id");

        if (id == null) {
            return "/login";
        }
        else {
            return "/mypage/mypageAdmin";
        }
    }

    @GetMapping("/update")
    public String goMypageUpdate(HttpSession session, Model model) {

        String studentID = (String) session.getAttribute("id");
        List<Member> profile = memberService.getMemberProfile(studentID);

        model.addAttribute("profile", profile);

        return "/mypage/update";
    }

    /* 회원 마이페이지 정보 수정 */    // 현재 하나의 정보만 변경하는 것이 불가능 -> 수정 필요
    @PostMapping("/update")
    public String doMyPageUpdate(@ModelAttribute Member member) {

        memberService.getMemberUpdate(member);
        return "redirect:/mypage";
    }

    @PostMapping("/delete")
    public String doMyPageDelete(HttpSession session,
                                 Model model) {
        String studentID = (String) session.getAttribute("id");

        List<Notice> noticeList = noticeService.getNoticeSelect();
        List<Notice> boardList = noticeService.getBoardSelect();
        memberService.getMemberDelete(studentID);

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("boardList", boardList);

        session.invalidate();
        return "/index";
    }
}
