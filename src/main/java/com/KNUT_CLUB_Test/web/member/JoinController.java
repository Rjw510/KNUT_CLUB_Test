package com.KNUT_CLUB_Test.web.member;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.MemberService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor

public class JoinController {

    @PostMapping("/join")
    public String doJoin(@RequestParam("name") String name, @RequestParam("studentID") String studentID, @RequestParam("password") String password,
                         @RequestParam("department") String department, @RequestParam("yy") String birth_yy, @RequestParam("mm") String birth_mm,
                         @RequestParam("dd") String birth_dd, @RequestParam("gender") String gender, @RequestParam("email_id") String em,
                         @RequestParam(value = "email_domain", defaultValue = "com") String domain, @RequestParam("phone") String phone, @RequestParam("address") String address,
                         @RequestParam("detailAddress") String detailAddress, HttpServletResponse response) throws IOException {

        /* alert */
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* parsing */
        if (birth_mm.length() == 1)
            birth_mm = '0'+birth_mm;

        if (birth_dd.length() == 1)
            birth_dd = '0'+birth_dd;

        String birth = birth_yy + "." + birth_mm + "." + birth_dd;
        String email = em + "@" + domain;

        MemberService service = new MemberService();
//        List<Member> list = service.getJoin(name, studentID, password, department, birth,
//                gender, email, phone, address, detailAddress);

        int count = service.checkMember(studentID);

        /* 예외 처리 */
        if(count != 0) {
            out.println("<script>alert('사용중인 학번입니다.'); </script>");
            out.flush();
            return "/join";
        }
        else {
            out.println("<script>alert('회원가입에 성공했습니다.'); </script>");
            out.flush();
            return "/login";
        }
    }
}
