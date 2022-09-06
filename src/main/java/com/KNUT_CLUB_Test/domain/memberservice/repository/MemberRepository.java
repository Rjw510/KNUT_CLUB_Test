package com.KNUT_CLUB_Test.domain.memberservice.repository;

import com.KNUT_CLUB_Test.domain.memberservice.Member;

import java.util.List;

public interface MemberRepository {

    String Login(Member member);

    String getMemberName(String studentID);

    String getMemberClub(String studentID);

    String getMemberGrade(String studentID);

    List<Member> getMemberProfile(String studentID);

    void getMemberUpdate(Member member);

    void getMemberDelete(String studentID);

    List<Member> getMemberList(String club, int page);

    List<Member> getPermissionList(String club, int page);

    int getMemberCount(String club);

    int getPermissionCount(String club);

    int delMemberAll(int[] ids);

    int delNonMemberAll(int[] ids);

    List<Member> getMemberClubJoin(String studentID);

}
