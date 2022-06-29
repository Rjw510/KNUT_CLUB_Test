package com.KNUT_CLUB_Test.web.club;

import com.KNUT_CLUB_Test.domain.club.Club;
import com.KNUT_CLUB_Test.domain.club.ClubService;
import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClubDetailController {

    @GetMapping("/clubJoin/detail")
    public String goClubDetail(@RequestParam("num") int num, Model model) {

        ClubService service = new ClubService();
        List<Club> list = service.getClubDetail(num);

        model.addAttribute("list", list);

        return "club/detail/clubJoinDetail";
    }
}
