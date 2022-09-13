package com.KNUT_CLUB_Test.domain.memberservice.service;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public String Login(Member member) {
        return memberRepository.Login(member);
    }

    @Override
    public String getMemberName(String studentID) {
        return memberRepository.getMemberName(studentID);
    }

    @Override
    public String getMemberEmail(String studentID) {
        return memberRepository.getMemberEmail(studentID);
    }

    @Override
    public String getMemberDepartment(String studentID) {
        return memberRepository.getMemberDepartment(studentID);
    }

    @Override
    public String getMemberClub(String studentID) {
        return memberRepository.getMemberClub(studentID);
    }

    @Override
    public boolean getMemberGrade(String studentID) {
        return memberRepository.getMemberGrade(studentID);
    }

    @Override
    public boolean getJoin(Member member, String birth, String gender) {
        return memberRepository.getJoin(member, birth, gender);
    }

    @Override
    public List<Member> getMemberProfile(String studentID) {
        return memberRepository.getMemberProfile(studentID);
    }

    @Override
    public void getMemberUpdate(String name,String studentID,String email,String department,String club) {
        memberRepository.getMemberUpdate(name, studentID, email, department, club);
    }

    @Override
    public void getMemberDelete(String studentID) {
        memberRepository.getMemberDelete(studentID);
    }

//    @Override
//    public List<Member> getMemberList(String club, int page) {
//        return memberRepository.getMemberList(club, page);
//    }
//
//    @Override
//    public List<Member> getPermissionList(String club, int page) {
//        return memberRepository.getPermissionList(club, page);
//    }
//
//    @Override
//    public int getMemberCount(String club) {
//        return memberRepository.getMemberCount(club);
//    }
//
//    @Override
//    public int getPermissionCount(String club) {
//        return memberRepository.getPermissionCount(club);
//    }
//
//    @Override
//    public int delMemberAll(int[] ids) {
//        return memberRepository.delMemberAll(ids);
//    }
//
//    @Override
//    public int delNonMemberAll(int[] ids) {
//        return memberRepository.delNonMemberAll(ids);
//    }
//
    @Override
    public List<Member> getMemberClubJoin(String studentID) {
        return memberRepository.getMemberClubJoin(studentID);
    }
}
