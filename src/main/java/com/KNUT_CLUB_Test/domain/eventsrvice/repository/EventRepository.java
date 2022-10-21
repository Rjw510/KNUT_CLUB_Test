package com.KNUT_CLUB_Test.domain.eventsrvice.repository;

import com.KNUT_CLUB_Test.domain.eventsrvice.Event;
import com.KNUT_CLUB_Test.domain.eventsrvice.EventPostDTO;

import java.util.List;

public interface EventRepository {

    List<Event> getEventList(String field, String field2, String query, String query2, int page);

    List<Event> getEventDetail(int num);

    boolean getEventWrite(EventPostDTO dto);
}
