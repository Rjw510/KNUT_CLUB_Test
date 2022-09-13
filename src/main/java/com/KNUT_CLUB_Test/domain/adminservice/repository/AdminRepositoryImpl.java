package com.KNUT_CLUB_Test.domain.adminservice.repository;

import com.KNUT_CLUB_Test.domain.adminservice.Admin;
import com.KNUT_CLUB_Test.domain.memberservice.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    @Override
    public String Login(Admin admin) {

        String sql = "SELECT id FROM ADMIN WHERE id = ? and password = ?";

        String id = "";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, admin.getId());
            pst.setString(2, admin.getPassword());
            rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
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
        return id;
    }

    @Override
    public String getAdminName(String id) {
        String name = "";

        String sql = "SELECT name FROM ADMIN WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();

            if(rs.next()) {
                name = rs.getString("name");
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
        return name;
    }

    @Override
    public String getAdminClub(String id) {
        String club = "";

        String sql = "SELECT club FROM ADMIN WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();

            if(rs.next()) {
                club = rs.getString("club");
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
        return club;
    }

    @Override
    public List<Member> getMemberList(String club, String field, String query, int page) {

        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM + 1 AS n, MEMBER.* " +
                "FROM MEMBER, (SELECT @ROWNUM := ?)TMP WHERE club = ? AND grade = 1 AND " + field + " LIKE ? limit ?, 10;";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, (page - 1) * 10);
            pst.setString(2, club);
            pst.setString(3, "%" + query + "%");
            pst.setInt(4, (page - 1) * 10);

            rs = pst.executeQuery();

            while(rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String name  = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                boolean grade = rs.getBoolean("grade");

                Member member = new Member(
                        n
                        , num
                        , name
                        , studentID
                        , department
                        , phone
                        , gender
                        , grade
                );
                memberList.add(member);
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
        return memberList;
    }

    @Override
    public List<Member> getPermissionList(String club, String field, String query, int page) {
        List<Member> permissionList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM + 1 AS n, MEMBER.* " +
                "FROM MEMBER, (SELECT @ROWNUM := ?)TMP WHERE club = ? AND grade = 0 AND " + field + " LIKE ? limit ?, 10;";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, (page - 1) * 10);
            pst.setString(2, club);
            pst.setString(3, "%" + query + "%");
            pst.setInt(4, (page - 1) * 10);

            rs = pst.executeQuery();

            while(rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String name  = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                boolean grade = rs.getBoolean("grade");

                Member member = new Member(
                        n
                        , num
                        , name
                        , studentID
                        , department
                        , phone
                        , gender
                        , grade
                );
                permissionList.add(member);
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
        return permissionList;
    }

    @Override
    public int getMemberCount(String club, String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM MEMBER WHERE club = ? and grade = 1";

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
            pst.setString(1, club);
            rs = pst.executeQuery();

            if(rs.next())
                count = rs.getInt("count");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
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
        return count;
    }

    @Override
    public int getPermissionCount(String club, String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM MEMBER WHERE club = ? and grade = 0";

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
            pst.setString(1, club);
            rs = pst.executeQuery();

            if(rs.next())
                count = rs.getInt("count");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
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
        return count;
    }

    @Override
    public int delMemberAll(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "UPDATE MEMBER SET club = '', motive = '', grade = 0 WHERE num IN ("+params+")";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            st = conn.createStatement();

            result = st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (st != null)
                    st.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }

    @Override
    public int delNonMemberAll(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "UPDATE MEMBER SET club = '', motive = '' WHERE num IN ("+params+")";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            st = conn.createStatement();

            result = st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (st != null)
                    st.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
