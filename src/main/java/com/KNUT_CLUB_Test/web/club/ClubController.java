package com.KNUT_CLUB_Test.web.club;

import com.KNUT_CLUB_Test.domain.club.Club;
import com.KNUT_CLUB_Test.domain.club.ClubService;
import com.KNUT_CLUB_Test.domain.member.ManageService;
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

    @GetMapping("/clubJoin")
    public String goClubJoin(@RequestParam(value = "select", required = false) String field_, @RequestParam(value = "campus", required = false) String query_, @RequestParam(value = "type", required = false) String query2_,
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

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        ClubService service = new ClubService();
        List<Club> list = service.getClubList(field, field2, query, query2, page);

        model.addAttribute("list", list);
        model.addAttribute("page", page_);
        return "club/clubJoin";
    }

    @GetMapping("/joinManual")
    public String goJoinManual() {
        return "club/joinManual";
    }

    @GetMapping("/clubJoin/membership")
//    @RequestParam("club") String club
    public String goMembership(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String club = (String) session.getAttribute("club");

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
