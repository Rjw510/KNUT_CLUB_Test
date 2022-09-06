package com.KNUT_CLUB_Test.web.memberList;

import com.KNUT_CLUB_Test.domain.memberservice.ManageService;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberListDetailController {

    @GetMapping("/memberList/detail")
    public String goMemberListDetail(@RequestParam("num") int num, Model model) {

        ManageService service = new ManageService();
//        List<Member> list = service.getMemberListDetail(num);

//        model.addAttribute("list", list);

        return "memberList/detail/memberListDetail";
    }

    @GetMapping("/permissionList/detail")
    public String goPermissionListDetail(@RequestParam("num") int num, Model model) {

        ManageService service = new ManageService();
//        List<Member> list = service.getMemberListDetail(num);
//
//        model.addAttribute("list", list);

        return "memberList/detail/permissionListDetail";
    }
}
