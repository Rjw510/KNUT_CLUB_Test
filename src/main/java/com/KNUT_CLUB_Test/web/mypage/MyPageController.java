package com.KNUT_CLUB_Test.web.mypage;

import com.KNUT_CLUB_Test.domain.member.Member;
import com.KNUT_CLUB_Test.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    @GetMapping("/myPage")
    public String goMP(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        String studentID = (String) session.getAttribute("id");

        MemberService service = new MemberService();
        List<Member> profile = service.getMemberProfile(studentID);


        model.addAttribute("profile", profile);

        return "mypage/mypage";
    }

}
