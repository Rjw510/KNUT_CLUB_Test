package com.KNUT_CLUB_Test.web.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClubDetailController {

    @GetMapping("/clubJoin/perfect")
    public String goPerfect() {
        return "club/clubJoin/perfect";
    }

    @GetMapping("/clubJoin/poseidon")
    public String goPoseidon() {
        return "club/clubJoin/poseidon";
    }

    @GetMapping("/clubJoin/return")
    public String goReturn() {
        return "club/clubJoin/return";
    }

    @GetMapping("/clubJoin/wicked")
    public String goWicked() {
        return "club/clubJoin/wicked";
    }

}
