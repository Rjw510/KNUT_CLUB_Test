package com.KNUT_CLUB_Test.domain.noticeservice.repository;

import com.KNUT_CLUB_Test.domain.memberservice.Member;
import com.KNUT_CLUB_Test.domain.noticeservice.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

    @Override
    public List<Notice> getNoticeSelect() {

        List<Notice> noticeList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, NOTICE.*"
                + " FROM NOTICE, (SELECT @ROWNUM := 0)TMP ORDER BY date DESC limit 5;";

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

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                int views = rs.getInt("views");

                Notice notice = new Notice(
                        n
                        , num
                        , title
                        , writer
                        , date
                        , views
                );

                noticeList.add(notice);
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
        return noticeList;
    }

    @Override
    public List<Notice> getBoardSelect() {

        List<Notice> boardList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, NOTICE.*"
                + " FROM NOTICE, (SELECT @ROWNUM := 0)TMP ORDER BY date DESC limit 5;";

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

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                int views = rs.getInt("views");

                Notice notice = new Notice(
                        n
                        , num
                        , title
                        , writer
                        , date
                        , views
                );

                boardList.add(notice);
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
        return boardList;
    }

    @Override
    public List<Notice> getNoticeList(String field, String query, int page) {

        List<Notice> noticeList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, NOTICE.*"
                + " FROM NOTICE, (SELECT @ROWNUM := ?)TMP WHERE " + field + " LIKE ? ORDER BY date DESC limit ?, 10;";


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
            pst.setInt(1, (page - 1) * 10);
            pst.setString(2, "%" + query + "%");
            pst.setInt(3, (page - 1) * 10);

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                int views = rs.getInt("views");

                Notice notice = new Notice(
                        n
                        , num
                        , title
                        , writer
                        , date
                        , views
                );
                noticeList.add(notice);
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
        return noticeList;
    }

    @Override
    public List<Notice> getBoardList(String field, String query, int page) {
        List<Notice> boardList = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, BOARD.*"
                + " FROM BOARD, (SELECT @ROWNUM := ?)TMP WHERE " + field + " LIKE ? ORDER BY date DESC limit ?, 10;";


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
            pst.setInt(1, (page - 1) * 10);
            pst.setString(2, "%" + query + "%");
            pst.setInt(3, (page - 1) * 10);

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                int views = rs.getInt("views");

                Notice notice = new Notice(
                        n
                        , num
                        , title
                        , writer
                        , date
                        , views
                );
                boardList.add(notice);
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
        return boardList;
    }

    @Override
    public int getNoticeCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM NOTICE";

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
    public int getBoardCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM BOARD";

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
    public List<Notice> getNoticeDetail(int num) {
        List<Notice> list = new ArrayList<>();

        String sql = "SELECT * FROM NOTICE WHERE num= ? ";

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
                num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                String content = rs.getString("content");
                int views = rs.getInt("views");

               Notice notice = new Notice(
                       num
                        , title
                        , writer
                        , date
                        , content
                        , views
                );
                list.add(notice);
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

    @Override
    public List<Notice> getBoardDetail(int num) {
        List<Notice> list = new ArrayList<>();

        String sql = "SELECT * FROM BOARD WHERE num= ? ";

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
                num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                String content = rs.getString("content");
                int views = rs.getInt("views");

                Notice notice = new Notice(
                        num
                        , title
                        , writer
                        , date
                        , content
                        , views
                );
                list.add(notice);
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

    @Override
    public List<Notice> writeNotice(String title,String writer,String content) {
        List<Notice> noticeWrite= new ArrayList<>();

        String sql = "INSERT INTO NOTICE(title, writer, content) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, writer);
            pst.setString(3, content);


            int rs = pst.executeUpdate();

            Notice notice = new Notice(
                    title
                    , writer
                    , content
            );
            noticeWrite.add(notice);


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
        return noticeWrite;
    }

    @Override
    public List<Notice> writeBoard(String title, String writer, String content) {
        List<Notice> boardWrite= new ArrayList<>();

        String sql = "INSERT INTO BOARD(title, writer, content) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, writer);
            pst.setString(3, content);


            int rs = pst.executeUpdate();

            Notice notice = new Notice(
                    title
                    , writer
                    , content
            );
            boardWrite.add(notice);


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
        return boardWrite;
    }

    @Override
    public void updateViews(int num) {


        String sql = "UPDATE NOTICE SET views = views+1 WHERE num = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
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
    public int delNoticeAll(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "DELETE FROM NOTICE WHERE num IN ("+params+")";

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
    public int delBoardAll(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "DELETE FROM BOARD WHERE num IN ("+params+")";

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
    public void delNotice(int num) {
        int result = 0;

        String params = "";

        String sql = "DELETE FROM NOTICE WHERE num = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
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
    public void delBoard(int num) {
        int result = 0;

        String params = "";

        String sql = "DELETE FROM BOARD WHERE num = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
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
    public void getNoticeUpdate(String content, int num) {
        List<Notice> list = new ArrayList<>();

        String sql = "UPDATE NOTICE SET content = ? WHERE num = ?";

        Connection conn = null;
        PreparedStatement pst = null;


        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, content);
            pst.setInt(2, num);
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
    public void getBoardUpdate(String content, int num) {
        List<Notice> list = new ArrayList<>();

        String sql = "UPDATE BOARD SET content = ? WHERE num = ?";

        Connection conn = null;
        PreparedStatement pst = null;


        String dbURL = "jdbc:mysql://localhost:4406/KNUT_CLUB";
        String dbID = "root";
        String dbPassword = "root";

        try {
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, content);
            pst.setInt(2, num);
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
}