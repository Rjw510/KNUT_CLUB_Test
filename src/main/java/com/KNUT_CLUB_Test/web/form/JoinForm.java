package com.KNUT_CLUB_Test.web.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class JoinForm {
    private String studentId;
    private String password;
    private String name;
    private String birth_yy;
    private String birth_mm;
    private String birth_dd;
    private String department;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String detailAddress;

}
