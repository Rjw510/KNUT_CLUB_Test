package com.KNUT_CLUB_Test.web.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClubController {

    @GetMapping("/clubJoin")
    public String goClubJoin() {
        return "club/clubJoin";
    }

    @GetMapping("/joinManual")
    public String goJoinManual() {
        return "club/joinManual";
    }

    @GetMapping("/clubJoin/clubdetail")
    public String goClubDetail() {
        return "club/clubJoin/clubdetail";
    }
}
