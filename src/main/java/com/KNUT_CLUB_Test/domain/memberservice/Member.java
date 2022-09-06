package com.KNUT_CLUB_Test.domain.memberservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
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
    private String grade;
    private String club;
    private String motive;

    /* 로그인 */
    private String studentID;
    private String password;


    public Member(String studentID, String password) {
        this.studentID = studentID;
        this.password = password;
    }

//    public Member(String name, String studentID, String password, String department, String birth,
//                  String gender, String email, String phone, String address, String detailAddress) {
//        this.name = name;
//        this.studentID = studentID;
//        this.password = password;
//        this.department = department;
//        this.birth = birth;
//        this.gender = gender;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//        this.detailAddress = detailAddress;
//    }
//
    public Member(String name, String email, String studentID, String department, String club) {
        this.name = name;
        this.email = email;
        this.studentID = studentID;
        this.department = department;
        this.club = club;
    }

    public Member(int n, int num, String name, String department, String gender, String grade, String studentID) {
        this.n = n;
        this.num = num;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.grade = grade;
        this.studentID = studentID;
    }

    public Member(String name, String department, String phone) {
        this.name = name;
        this.department = department;
        this.phone = phone;
    }

    //
//    public Member(int n, int num, String name, String studentID, String department, String phone, String club, String motive) {
//        this.n = n;
//        this.num = num;
//        this.name = name;
//        this.studentID = studentID;
//        this.department = department;
//        this.phone = phone;
//        this.club = club;
//        this.motive = motive;
//    }
//
//
//    public Member(int num, String name, String department, String studentID, String phone, String club, String motive) {
//        this.num = num;
//        this.name = name;
//        this.department = department;
//        this.studentID = studentID;
//        this.phone = phone;
//        this.club = club;
//        this.motive = motive;
//    }
}
