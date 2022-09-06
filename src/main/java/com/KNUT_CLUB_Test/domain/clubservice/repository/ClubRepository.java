package com.KNUT_CLUB_Test.domain.clubservice.repository;

import com.KNUT_CLUB_Test.domain.clubservice.Club;

import java.util.List;

public interface ClubRepository {

    List<Club> getClubList(String campus, String type, String cWord, String tWord);
    List<Club> getClubDetail(int num);
}
