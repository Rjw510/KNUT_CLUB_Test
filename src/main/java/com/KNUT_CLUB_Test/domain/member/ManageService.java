package com.KNUT_CLUB_Test.domain.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManageService {

    public List<Member> getMemberList(String club) {

        List<Member> list = new ArrayList<>();

        String sql = "SELECT * FROM MEMBER WHERE club = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, club);
            rs = pst.executeQuery();

            while(rs.next()) {
                int num = rs.getInt("num");
                String name  = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");
                String phone = rs.getString("phone");
                club = rs.getString("club");

                Member member = new Member(
                        num
                        , name
                        , studentID
                        , department
                        , phone
                        , club
                );
                list.add(member);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public void joinClub(String id, String club) {

        String sql = "UPDATE MEMBER SET club = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, club);
            pst.setString(2, id);
            rs = pst.executeQuery();

            while(rs.next()) {

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
