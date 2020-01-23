package com.it.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.it.dto.MemberVO;

public class MemberDAO {

   private MemberDAO() {

   }

   private static MemberDAO instance = new MemberDAO();

   public static MemberDAO getInstance() {
      return instance;

   }

   public Connection getConnection() throws Exception {
      Connection conn = null;
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:/comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
      conn = ds.getConnection();
      return conn;
   }

//사용자 인증시 사용하는 메소드
   public int memberCheck(String memId, String memPwd) {
      int result = -1;
      String sql = "select mem_pwd from member where mem_id=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,memId );
         rs = pstmt.executeQuery();
         if (rs.next()) {
            if (rs.getString("mem_pwd") != null && rs.getString("mem_pwd").equals(memPwd)) {
               result = 1;
            } else {
               result = -1;
            }

         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }

      }
      return result;
   }

//아이디로 회원 정보 가져오는 메소드
   public MemberVO getMember(String memId) {
      MemberVO mVo = null;
      String sql = "select * from member where mem_id=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, memId);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            mVo = new MemberVO();
            mVo.setMemId(rs.getString("mem_id"));
            mVo.setMemName(rs.getString("mem_name"));
            mVo.setMemPwd(rs.getString("mem_pwd"));
            mVo.setMemPhone(rs.getString("mem_phone"));
            mVo.setMemEmail(rs.getString("mem_email"));
            mVo.setMemAuth(rs.getInt("mem_auth"));
            mVo.setAdminId(rs.getString("admin_id"));
            

         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return mVo;
   }
   
   public int confirmId(String memid){//아이디 중복 체크를 위한 메소드 추가
      int result = -1;
      String sql = " select memid from member where mem_id=?";
      Connection conn =null;
      PreparedStatement pstmt =null;
      ResultSet rs = null;
      try{
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, memid);
         rs = pstmt.executeQuery();
         if (rs.next()){
            result = 1;
         }else {
            result = -1;
         }
      }catch (Exception e) {
         e.printStackTrace();
      }finally{
         try{
            if (rs != null)   rs.close();
            if (pstmt !=null)   pstmt.close();
            if (conn != null)   conn.close();  
         }catch (Exception e) {
            e.printStackTrace();
         }
      }
   
      return result;
   }
   
   public int insertMember(MemberVO mVo){
      int result=-1;
      String sql = "insert into member("
            + "mem_id, mem_name, mem_pwd, mem_phone, mem_email,mem_auth,admin_id ) "
            + "values(member_seq.nextval,?, ?, ?, ?, ?, ?,? ) " ;
      
      Connection conn= null;
      PreparedStatement pstmt =null;
      try{
         conn = getConnection();
         pstmt= conn.prepareStatement(sql);
         pstmt.setString(1, mVo.getMemId());
         pstmt.setString(2, mVo.getMemName());
         pstmt.setString(3, mVo.getMemPwd());
         pstmt.setString(4, mVo.getMemPhone());
         pstmt.setString(5, mVo.getMemEmail());
         pstmt.setInt(6, mVo.getMemAuth());
         pstmt.setString(7, mVo.getAdminId());
         result = pstmt.executeUpdate();
      }catch (Exception e){
         e.printStackTrace();
      }finally{
         try{
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
   return result;
   }
   
   
   //회원정보 바꾸기  이거 사용할라나?????
   /*public int updateMember(MemberVO mVo){
      int result = -1;
      String sql = "update member set mem_pwd=?, mem_email=?,"
            + "mem_phone=?, mem_admin=? where mem_userid=?";
      Connection conn = null;
      PreparedStatement pstmt= null;
      try{
         conn = getConnection();
         pstmt =  conn.prepareStatement(sql);
         pstmt.setString(1, mVo.getMemId());
         pstmt.setString(2, mVo.getMemName());
         pstmt.setString(3, mVo.getMemPwd());
         pstmt.setString(4, mVo.getMemPhone());
         pstmt.setString(5, mVo.getMeMemail());
         pstmt.setInt(6, mVo.getMemAuth());
         pstmt.setString(7, mVo.getAdminId());
         result = pstmt.executeUpdate();
      }catch (Exception e) {
         e.printStackTrace();
      }finally{
         try{
            if(pstmt !=null)     pstmt.close();
            if(conn !=null)      conn.close();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
   return result;
   }*/
   
}