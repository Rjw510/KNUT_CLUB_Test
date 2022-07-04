package com.KNUT_CLUB_Test.web.memberList;

import com.KNUT_CLUB_Test.domain.member.ManageService;
import com.KNUT_CLUB_Test.domain.member.Member;
import com.KNUT_CLUB_Test.domain.member.MemberService;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/delMember")
    public String delMember(@RequestParam("del_id") String[] delIds) {
        ManageService service = new ManageService();
        int[] ids = new int[delIds.length];

        for(int i=0; i<delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = service.delMemberAll(ids);

        return "redirect:/memberList";
    }

    @GetMapping("/permissionList")
    public String goPermissionList(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String club = String.valueOf(session.getAttribute("club"));

        ManageService service = new ManageService();
        List<Member> list = service.getPermissionList(club);

        model.addAttribute("list", list);

        return "memberList/permissionList";
    }

    @PostMapping("/permissionMember")
    public String permissionMember(@RequestParam("permission_id") String[] permissionIds) {
        ManageService service = new ManageService();
        int[] ids = new int[permissionIds.length];

        for(int i=0; i<permissionIds.length; i++)
            ids[i] = Integer.parseInt(permissionIds[i]);

        int result = service.permissionMemberAll(ids);

        return "redirect:/permissionList";
    }

    @PostMapping("/delNonMember")
    public String delNonMember(@RequestParam("permission_id") String[] permissionIds) {
        ManageService service = new ManageService();
        int[] ids = new int[permissionIds.length];

        for(int i=0; i<permissionIds.length; i++)
            ids[i] = Integer.parseInt(permissionIds[i]);

        int result = service.delNonMemberAll(ids);

        return "redirect:/memberList";
    }
}
