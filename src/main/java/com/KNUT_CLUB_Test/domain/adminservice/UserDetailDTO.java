package com.KNUT_CLUB_Test.domain.adminservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserDetailDTO {

    private String name;
    private String studentId;
    private String email;
    private String phone;
    private String department;
    private String birth;
    private String address;
    private String img;
}
