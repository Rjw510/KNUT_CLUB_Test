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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;
    private final NoticeService noticeService;

    /* 회원 마이페이지 이동 */
    @GetMapping
    public String goMyPage(HttpSession session, Model model) {

        String studentID = (String) session.getAttribute("id");

//        if (studentID == null) {
//            model.addAttribute("message", "로그인 후 이용부탁드립니다.");
//            model.addAttribute("url", "/index");
//            return "/alert";
//        }
//        else {
//            List<Member> profile = memberService.getMemberProfile(studentID);
//            model.addAttribute("profile", profile);
//            return "/mypage/mypage";
//        }

        List<Member> profile = memberService.getMemberProfile(studentID);
        model.addAttribute("profile", profile);
        return "/mypage/mypage";
    }

    /* 관리자 마이페이지 이동 */
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

    /* 회원 마이페이지 이동 */
    @GetMapping("/update")
    public String goMypageUpdate(HttpSession session, Model model) {

        String studentID = (String) session.getAttribute("id");
        List<Member> profile = memberService.getMemberProfile(studentID);

        model.addAttribute("profile", profile);

        return "/mypage/update";
    }

    /* 회원 마이페이지 정보 수정 */
    @PostMapping("/update")
    public String doMyPageUpdate(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("department") String department,
                                 @RequestParam("club") String club,
                                 HttpSession session) {

        String studentID = (String) session.getAttribute("id");

        if (name.equals("")) {
            name = memberService.getMemberName(studentID);
        }

        if (email.equals("")) {
            email = memberService.getMemberEmail(studentID);
        }

        if (department.equals("")) {
            department = memberService.getMemberDepartment(studentID);
        }

        if (club.equals("")) {
            club = memberService.getMemberClub(studentID);
        }

        memberService.getMemberUpdate(name, studentID, email, department, club);
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
