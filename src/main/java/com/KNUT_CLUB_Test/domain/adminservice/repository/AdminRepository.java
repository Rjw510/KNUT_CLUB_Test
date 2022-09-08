package com.KNUT_CLUB_Test.domain.adminservice.repository;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;

public interface AdminRepository {

    String Login(Admin admin);

    String getAdminName(String id);

    String getAdminClub(String id);
}
