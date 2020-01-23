package com.it.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.it.dto.NoticeVO;

import util.DBManager;

public class NoticeDAO {
   private NoticeDAO() {
   }
     private static NoticeDAO instance = new NoticeDAO();

      public static NoticeDAO getInstance() {
         return instance;
      }
      
      //공지글 모두 보여주기
      public List<NoticeVO> selectAllNotices() {
         String sql = "select * from notice order by notice_no desc";
         List<NoticeVO> list = new ArrayList<NoticeVO>();
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         try {
            conn = DBManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
               NoticeVO nVo = new NoticeVO();
               nVo.setNotiNo(rs.getString("noti_no"));
               nVo.setNotiTitle(rs.getString("noti_title"));
               nVo.setNotiContents(rs.getString("noti_contents"));
               nVo.setNotiDate(rs.getString("noti_date"));
               nVo.setAdminId(rs.getString("admine_id"));
               list.add(nVo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            DBManager.close(conn, stmt, rs);
         }
         return list;
      }
      
      
      //공지글 추가
      public void insertNotice(NoticeVO nVo) {
         String sql = "insert into notice ("
               + "noti_no, noti_title, noti_contents, admin_id, noti_date) "
               + "values(notice_seq.nextval, ?, ?, ?,sysdate ) " ;
         Connection conn = null;
         PreparedStatement pstmt = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nVo.getNotiTitle());
            pstmt.setString(2, nVo.getNotiContents());
            pstmt.setString(3, nVo.getAdminId());
            pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            DBManager.close(conn, pstmt);
         }
      }
      
      //공지글 조회수
      public void updateReadCount(String notiNo) {
         String sql = "update notice set readcount = readcount+1 where noti_no=?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notiNo);
            pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            DBManager.close(conn, pstmt);
         }
      }
      
   // 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
      public NoticeVO selectOneNoticeByNoticeNo(String notiNo) {
         String sql = "select * from notice where noti_no = ?";
         NoticeVO nVo = null;
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notiNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
               nVo = new NoticeVO();
               nVo.setNotiNo(rs.getString("noti_no"));
               nVo.setNotiTitle(rs.getString("noti_title"));
               nVo.setNotiContents(rs.getString("noti_contents"));
               nVo.setNotiDate(rs.getString("noti_date"));
               nVo.setAdminId(rs.getString("admin_id"));
            
            }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            DBManager.close(conn, pstmt, rs);
         }
         return nVo;
      }
      
      //공지글 수정
      public void updateNotice(NoticeVO nVo) {
         String sql = "update notice set noti_no=?, noti_date=sysdate, admin_id=?, "
               + " noti_title=?, noti_contents=? where noti_no=?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nVo.getNotiNo());
            pstmt.setString(2, nVo. getNotiTitle());
            pstmt.setString(3, nVo.getNotiContents());
            pstmt.setString(4, nVo. getNotiDate());
            pstmt.setString(5, nVo.getAdminId());
            pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            DBManager.close(conn, pstmt);
         }
      }

      
      //게시글 내용화인
      public NoticeVO checknotiContentsWord(String notiContents, String notiNo) {
         String sql = "select * from notice where noti_contents=? and noti_no =?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         NoticeVO nVo = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notiContents);
            pstmt.setString(2, notiNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
               nVo = new NoticeVO();
               nVo.setNotiNo(rs.getString("noti_no"));
               nVo.setNotiTitle(rs.getString("noti_title"));
               nVo.setNotiContents(rs.getString("noti_contents"));
               nVo.setNotiDate(rs.getString("noti_date"));
               nVo.setAdminId(rs.getString("admin_id"));
               
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return nVo;
      }

      //공지글 지우기
      public void deleteNotice(String notiNo) {
         String sql = "delete notice where noti_no=?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notiNo);
            pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

    }