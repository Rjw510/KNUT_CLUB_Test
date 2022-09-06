package com.KNUT_CLUB_Test.web.club;

import com.KNUT_CLUB_Test.domain.clubservice.Club;
import com.KNUT_CLUB_Test.domain.clubservice.service.ClubService;
import com.KNUT_CLUB_Test.domain.memberservice.ManageService;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.service.MemberService;
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
public class ClubController {

    private final ClubService clubService;
    private final MemberService memberService;

    @GetMapping("/clubJoin")
    public String goClubJoin(@RequestParam(value = "select", required = false) String field_,
                             @RequestParam(value = "campus", required = false) String query_,
                             @RequestParam(value = "type", required = false) String query2_,
                             @RequestParam(value = "p", required = false) String page_, Model model) {

        String field = "campus";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String field2 = "type";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        String query2 = "";
        if (query2_ != null && !query2_.equals(""))
            query2 = query2_;

        List<Club> clubList = clubService.getClubList(field, field2, query, query2);

        model.addAttribute("clubList", clubList);

        return "club/clubJoin";
    }

    @GetMapping("/clubJoin/detail")
    public String goClubDetail(@RequestParam("num") int num,
                               Model model) {

        List<Club> clubList = clubService.getClubDetail(num);
        model.addAttribute("clubList", clubList);

        return "/club/detail/clubJoinDetail";
    }

    @GetMapping("/joinManual")
    public String goJoinManual() {
        return "club/joinManual";
    }


    /* 여기서부터~ */
    @GetMapping("/clubJoin/membership")
    public String goMembership(@RequestParam("name") String clubName,
                               HttpSession session,
                               Model model) {

        System.out.println("clubName = " + clubName);
        String studentID = (String) session.getAttribute("studentID");
        List<Member> profile = memberService.getMemberClubJoin(studentID);

        model.addAttribute("profile", profile);
        model.addAttribute("clubName", clubName);
        return "club/membership";
    }

    @PostMapping("/clubJoin/membership")
    public String doMembership(@RequestParam("content") String motive, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        String clubName = (String) session.getAttribute("clubName");

        ManageService service = new ManageService();
        service.joinClub(id, clubName, motive);

        return "redirect:/clubJoin";
    }

}
