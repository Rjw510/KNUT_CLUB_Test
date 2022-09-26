package com.KNUT_CLUB_Test.domain.memberservice.repository;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.web.form.JoinForm;

import java.util.List;

public interface MemberRepository {

    String Login(Member member);

    String getMemberName(String studentID);

    String getMemberEmail(String studentID);

    String getMemberDepartment(String studentID);

    String getMemberClub(String studentID);

    boolean getMemberGrade(String studentID);

    boolean getJoin(JoinForm joinForm, String birth, String gender);

    List<Member> getMemberProfile(String studentID);

    void getMemberUpdate(String name,String studentID,String email,String department,String club);

    void getMemberDelete(String studentID);

    List<Member> getMemberClubJoin(String studentID);

}
