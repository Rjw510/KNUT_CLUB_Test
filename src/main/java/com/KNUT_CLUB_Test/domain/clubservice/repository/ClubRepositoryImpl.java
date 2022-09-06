package com.KNUT_CLUB_Test.domain.clubservice.repository;

import com.KNUT_CLUB_Test.domain.clubservice.Club;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClubRepositoryImpl implements ClubRepository{
    @Override
    public List<Club> getClubList(String campus, String type, String cWord, String tWord) {
        List<Club> clubList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 as n, PROMOTION.*"
                + " FROM PROMOTION, (SELECT @ROWNUM := 0)TMP WHERE " + campus + " Like ? and " + type + " LIKE ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + cWord + "%");
            pst.setString(2, "%" + tWord + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String img = rs.getString("img");

                Club club = new Club (
                        num
                        , name
                        , img
                );
                clubList.add(club);
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
        return clubList;

    }

    @Override
    public List<Club> getClubDetail(int num) {
        List<Club> clubList = new ArrayList<>();

        String sql = "SELECT * FROM PROMOTION WHERE num= ? ";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);

            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String introduce = rs.getString("introduce");
                String promotion = rs.getString("promotion");
                String img = rs.getString("img");

                Club club = new Club (
                        name
                        , introduce
                        , promotion
                        , img
                );
                clubList.add(club);
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
        return clubList;
    }
}
