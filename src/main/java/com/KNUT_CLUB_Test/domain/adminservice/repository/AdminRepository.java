package com.KNUT_CLUB_Test.domain.adminservice.repository;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.web.form.AdminJoinForm;

import java.util.List;

public interface AdminRepository {

    String Login(Admin admin);

    String getAdminName(String id);

    String getAdminClub(String id);

    List<Member> getMemberList(String club, String field, String query, int page);

    List<Member> getPermissionList(String club, String field, String query, int page);

    int getMemberCount(String club, String field, String query);

    int getPermissionCount(String club, String field, String query);

    int delMemberAll(int[] ids);

    int delNonMemberAll(int[] ids);

    boolean getJoin(AdminJoinForm joinForm);
}
