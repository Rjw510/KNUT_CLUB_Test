package com.KNUT_CLUB_Test.web.event;



import com.KNUT_CLUB_Test.domain.eventsrvice.Event;
import com.KNUT_CLUB_Test.domain.eventsrvice.EventPostDTO;
import com.KNUT_CLUB_Test.domain.eventsrvice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event")
    public String goEvent(@RequestParam(value = "select", required = false) String field_,
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

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        List<Event> list = eventService.getEventList(field, field2, query, query2, page);

        model.addAttribute("list", list);
        model.addAttribute("page", page_);
        return "event/event";
    }

    @GetMapping("/event/detail")
    public String goClubDetail(@RequestParam("num") int num,
                               Model model) {

        List<Event> eventList = eventService.getEventDetail(num);
        model.addAttribute("eventList", eventList);

        return "/event/detail/eventDetail";
    }

    @GetMapping("/event/write")
    public String goEventWrite(Model model) {

        model.addAttribute("eventPost", new EventPostDTO());

        return "/event/newEvent";
    }

    @PostMapping("/event/write")
    public String doEventWrite(@ModelAttribute("eventPost") EventPostDTO dto) {

        List<EventPostDTO> postList = null;
    }


}
