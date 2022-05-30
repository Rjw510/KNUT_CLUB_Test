package com.KNUT_CLUB_Test.web.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class EventController {

    @GetMapping("/event")
    public String goEvent() {
        return "event/event";
    }
}
