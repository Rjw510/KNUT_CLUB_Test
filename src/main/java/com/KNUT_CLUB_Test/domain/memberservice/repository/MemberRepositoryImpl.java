package com.KNUT_CLUB_Test.domain.memberservice.repository;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Override
    public String Login(Member member) {

        String sql = "SELECT studentID FROM MEMBER WHERE studentID = ? and password = ?";

        String studentID = "";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, member.getStudentID());
            pst.setString(2, member.getPassword());
            rs = pst.executeQuery();

            if (rs.next()) {
                studentID = rs.getString("studentID");
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
        return studentID;
    }

    @Override
    public String getMemberName(String studentID) {

        String name = "";

        String sql = "SELECT name FROM MEMBER WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);
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
    public String getMemberClub(String studentID) {

        String club = "";

        String sql = "SELECT club FROM MEMBER WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);
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
    public String getMemberGrade(String studentID) {

        String authority = "";

        String sql = "SELECT grade FROM MEMBER WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);
            rs = pst.executeQuery();

            if(rs.next()) {
                authority = rs.getString("grade");
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
        return authority;
    }

    @Override
    public void getJoin(Member member, String birth, String gender) {

        List<Member> memberList = new ArrayList<>();

        String sql = "INSERT INTO MEMBER(name, studentID, password, department, birth, gender, email," +
                " phone, address, detailAddress) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;
        int rs = 0;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, member.getName());
            pst.setString(2, member.getStudentID());
            pst.setString(3, member.getPassword());
            pst.setString(4, member.getDepartment());
            pst.setString(5, birth);
            pst.setString(6, gender);
            pst.setString(7, member.getEmail());
            pst.setString(8, member.getPhone());
            pst.setString(9, member.getAddress());
            pst.setString(10, member.getDetailAddress());

            rs = pst.executeUpdate();

//            Member member = new Member (
//                    name
//                    ,studentID
//                    ,password
//                    ,department
//                    ,birth
//                    ,gender
//                    ,email
//                    ,phone
//                    ,address
//                    ,detailAddress
//            );
            memberList.add(member);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public List<Member> getMemberProfile(String studentID) {

        List<Member> profile = new ArrayList<>();

        String sql = "SELECT name, email, studentID, department, club FROM MEMBER WHERE studentID = ?;";

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
            pst.setString(1, studentID);

            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                String club = rs.getString("club");
                studentID = rs.getString("studentID");

                Member member = new Member(
                        name
                        , email
                        , studentID
                        , department
                        , club
                );
                profile.add(member);
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
        return profile;
    }

    @Override
    public void getMemberUpdate(Member member) {

        String sql = "UPDATE MEMBER SET name = ?, studentID = ?, email = ?, department = ?, club = ? WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;


        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, member.getName());
            pst.setString(2, member.getStudentID());
            pst.setString(3, member.getEmail());
            pst.setString(4, member.getDepartment());
            pst.setString(5, member.getClub());
            pst.setString(6, member.getStudentID());
            int rs = pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void getMemberDelete(String studentID) {

        List<Member> list = new ArrayList<>();

        String sql = "DELETE FROM MEMBER WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;


        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);
            int rs = pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public List<Member> getMemberList(String club, int page) {

        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM + 1 AS n, MEMBER.* " +
                "FROM MEMBER, (SELECT @ROWNUM := ?)TMP WHERE club = ? and grade = '회원'";

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
            rs = pst.executeQuery();

            while(rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String name  = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");
                String phone = rs.getString("phone");
                club = rs.getString("club");

                Member member = new Member(
                    n
                    , num
                    , name
                    , studentID
                    , department
                    , phone
                    ,club
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
    public List<Member> getPermissionList(String club, int page) {
        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM + 1 AS n, MEMBER.* " +
                "FROM MEMBER, (SELECT @ROWNUM := ?)TMP WHERE club = ? and grade = '비회원'";

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
            rs = pst.executeQuery();

            while(rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String name  = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");
                String phone = rs.getString("phone");
                club = rs.getString("club");

                Member member = new Member(
                        n
                        , num
                        , name
                        , studentID
                        , department
                        , phone
                        ,club
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
    public int getMemberCount(String club) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM MEMBER WHERE club = ? and grade = '회원'";

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
    public int getPermissionCount(String club) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM MEMBER WHERE club = ? and grade = '비회원'";

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

        String sql = "UPDATE MEMBER SET club = '', motive = '', authority = 4 WHERE num IN ("+params+")";

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

        String sql = "UPDATE MEMBER SET club = '', motive = '', authority = 4 WHERE num IN ("+params+")";

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
    public List<Member> getMemberClubJoin(String studentID) {
        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT name, department, phone FROM MEMBER WHERE studentID = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);

            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                String phone = rs.getString("phone");

                Member member = new Member(
                        name
                        , department
                        , phone
                );
                memberList.add(member);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
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
}

