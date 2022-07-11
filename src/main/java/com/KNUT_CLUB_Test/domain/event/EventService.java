package com.KNUT_CLUB_Test.domain.event;

import com.KNUT_CLUB_Test.domain.club.Club;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventService {

    public List<Event> getEventList(String field, String field2, String query, String query2, int page) {

        List<Event> list = new ArrayList<>();
//        select @rownum := @rownum+1 as n, promotion.* FROM promotion, (select @rownum := 0) tmp where campus like '%충주%' and type like '%%' ;
        String sql = "SELECT @ROWNUM := @ROWNUM +1 as n, EVENT.*"
                + " FROM EVENT, (SELECT @ROWNUM := 0)TMP WHERE " + field + " Like ? and " + field2 + " LIKE ?";

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
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                String img = rs.getString("img");

                Event event = new Event (
                        num
                        , name
                        , date
                        , img
                );
                list.add(event);
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
