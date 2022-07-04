package com.KNUT_CLUB_Test.web.notice;

import com.KNUT_CLUB_Test.domain.notice.Notice;
import com.KNUT_CLUB_Test.domain.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    @GetMapping("/notice")
    public String goNotice(@RequestParam(value = "select", required = false) String field_, @RequestParam(value = "word", required = false) String query_,
                           @RequestParam(value = "p", required = false) String page_, Model model) {

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeSelect(field, query, page);

        // 총 게시물 수
        int count = service.getNoticeCount(field, query);


        model.addAttribute("list", list);
        model.addAttribute("count", count);
        model.addAttribute("page", page_);

        return "notice/notice";
    }

    @PostMapping("/delNotice")
    public String delNotice(@RequestParam("del_id") String[] delIds) {
        NoticeService service = new NoticeService();
        int[] ids = new int[delIds.length];

        for(int i=0; i<delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = service.delNoticeAll(ids);

        return "redirect:/notice";
    }

    @GetMapping ("/board")
    public String goBoard(@RequestParam(value = "select", required = false) String field_, @RequestParam(value = "word", required = false) String query_,
                          @RequestParam(value = "p", required = false) String page_, Model model) {

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        NoticeService service = new NoticeService();
        List<Notice> list = service.getBoardSelect(field, query, page);
        int count = service.getBoardCount(field, query);

        model.addAttribute("list", list);
        model.addAttribute("count", count);


        return "notice/board";
    }

    @PostMapping("/delBoard")
    public String delBoard(@RequestParam("del_id") String[] delIds, HttpSession session) {
        NoticeService service = new NoticeService();
        int[] ids = new int[delIds.length];

        String name = (String) session.getAttribute("name");

        for(int i=0; i<delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = service.delBoardAll(ids, name);

        return "redirect:/board";
    }
}
