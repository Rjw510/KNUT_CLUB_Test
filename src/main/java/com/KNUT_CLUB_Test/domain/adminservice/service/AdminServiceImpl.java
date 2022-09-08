package com.KNUT_CLUB_Test.domain.adminservice.service;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;
import com.KNUT_CLUB_Test.domain.adminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Override
    public String Login(Admin admin) {
        return adminRepository.Login(admin);
    }

    @Override
    public String getAdminName(String id) {
        return adminRepository.getAdminName(id);
    }

    @Override
    public String getAdminClub(String id) {
        return adminRepository.getAdminClub(id);
    }
}
