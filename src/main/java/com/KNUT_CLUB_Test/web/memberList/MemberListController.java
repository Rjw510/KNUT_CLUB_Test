package com.KNUT_CLUB_Test.web.memberList;

import com.KNUT_CLUB_Test.domain.member.ManageService;
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
public class MemberListController {

    @GetMapping("/memberList")
    public String goMemberList(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String club = String.valueOf(session.getAttribute("club"));

        ManageService service = new ManageService();
        List<Member> list = service.getMemberList(club);

        model.addAttribute("list", list);

        return "memberList/memberList";
    }

    @GetMapping("/permissionList")
    public String goPermissionList() {
        return "memberList/permissionList";
    }
}
