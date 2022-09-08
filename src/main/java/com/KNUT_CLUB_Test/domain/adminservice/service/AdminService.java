package com.KNUT_CLUB_Test.domain.adminservice.service;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;

public interface AdminService {

    String Login(Admin admin);

    String getAdminName(String id);

    String getAdminClub(String id);
}
