package com.KNUT_CLUB_Test.domain.member;

import com.KNUT_CLUB_Test.domain.login.Login;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Member {
    private int n;
    private int num;
    private String name;
    private String department;
    private String birth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String detailAddress;
    private String club;
    private String motive;

    Login login = new Login();

    String studentID = login.getStdentID();
    String password = login.getPassword();


    public Member(String name, String studentID, String password, String department, String birth,
                  String gender, String email, String phone, String address, String detailAddress) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.department = department;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public Member(String name, String email, String studentID, String department, String club) {
        this.name = name;
        this.email = email;
        this.studentID = studentID;
        this.department = department;
        this.club = club;
    }

    public Member(int n, int num, String name, String studentID, String department, String phone, String club, String motive) {
        this.n = n;
        this.num = num;
        this.name = name;
        this.studentID = studentID;
        this.department = department;
        this.phone = phone;
        this.club = club;
        this.motive = motive;
    }


    public Member(int num, String name, String department, String studentID, String phone, String club, String motive) {
        this.num = num;
        this.name = name;
        this.department = department;
        this.studentID = studentID;
        this.phone = phone;
        this.club = club;
        this.motive = motive;
    }
}
