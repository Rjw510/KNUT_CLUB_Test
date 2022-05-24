package com.KNUT_CLUB_Test.web.fragment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HeaderController {

    @GetMapping("/header")
    public String header(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String authority = (String) session.getAttribute("authority");
        System.out.println("authority = " + authority);

        model.addAttribute("authority", authority);

        return "fragments/header";
    }
}
