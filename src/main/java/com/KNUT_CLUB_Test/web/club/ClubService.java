package com.KNUT_CLUB_Test.web.club;

import com.KNUT_CLUB_Test.domain.notice.Notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClubService {

    public List<Club> getClubList(String field, String field2, String query, String query2, int page) {

        List<Club> list = new ArrayList<>();
//        select @rownum := @rownum+1 as n, promotion.* FROM promotion, (select @rownum := 0) tmp where campus like '%충주%' and type like '%%' ;
        String sql = "SELECT @ROWNUM := @ROWNUM +1 as n, PROMOTION.*"
                + " FROM PROMOTION, (SELECT @ROWNUM := 0)TMP WHERE " + field + " Like ? and " + field2 + " LIKE ?";

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
            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query2 + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("num");
                String campus = rs.getString("campus");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String activity = rs.getString("activity");
                String introduce = rs.getString("introduce");
                String promotion = rs.getString("promotion");
                String img = rs.getString("img");

                Club club = new Club (
                        num
                        , campus
                        , type
                        , name
                        , activity
                        , introduce
                        , promotion
                        , img
                );
                list.add(club);
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
}
