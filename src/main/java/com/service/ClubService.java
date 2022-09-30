package com.service;

import com.KNUT_CLUB_Test.domain.clubservice.Club;

import java.util.List;

public interface ClubService {

    List<Club> getClubList(String campus, String type, String cWord, String tWord);

    List<Club> getClubDetail(int num);

    void joinClub(String id, String club, String motive);
}
