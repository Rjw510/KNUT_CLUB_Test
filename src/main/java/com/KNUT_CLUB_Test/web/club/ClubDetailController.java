package com.KNUT_CLUB_Test.web.club;

import com.KNUT_CLUB_Test.domain.club.Club;
import com.KNUT_CLUB_Test.domain.club.ClubService;
import com.KNUT_CLUB_Test.domain.member.ManageService;
import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClubDetailController {

    @GetMapping("/clubJoin/detail")
    public String goClubDetail(@RequestParam("num") int num, HttpServletRequest request, Model model) {

//        HttpSession session = request.getSession();

        ClubService service = new ClubService();
        ManageService manageService = new ManageService();

        String name = manageService.getClubName(num);
        List<Club> list = service.getClubDetail(num);

        model.addAttribute("list", list);
        model.addAttribute("name", name);

        return "/club/detail/clubJoinDetail";
    }
}
