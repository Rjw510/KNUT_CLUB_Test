package com.KNUT_CLUB_Test.web.member;

import com.KNUT_CLUB_Test.domain.member.Member;
import com.KNUT_CLUB_Test.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class JoinController {

    //  chk_1, chk_2 값 받아서 페이지 이동
    @GetMapping("/check/join")
    public String goJoin() {
        return "join";
    }

    @PostMapping("/join")
    public String doJoin(@RequestParam("name") String name, @RequestParam("studentID") String studentID, @RequestParam("password") String password,
                         @RequestParam("department") String department, @RequestParam("yy") String birth_yy, @RequestParam("mm") String birth_mm,
                         @RequestParam("dd") String birth_dd, @RequestParam("gender") String gender, @RequestParam("email_id") String em,
                         @RequestParam(value = "email_domain", defaultValue = "com") String domain, @RequestParam("phone") String phone, @RequestParam("address") String address,
                         @RequestParam("detailAddress") String detailAddress) {

        if (birth_mm.length() == 1)
            birth_mm = '0'+birth_mm;

        if (birth_dd.length() == 1)
            birth_dd = '0'+birth_dd;

        String birth = birth_yy + "." + birth_mm + "." + birth_dd;
        String email = em + "@" + domain;

        MemberService service = new MemberService();
        List<Member> list = service.getJoin(name, studentID, password, department, birth,
                gender, email, phone, address, detailAddress);

        return "login";

    }


}
