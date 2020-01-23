package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.it.dto.AdminVO;

import util.DBManager;

public class AdminDAO {
	private AdminDAO() {
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public List<AdminVO> selectAllAdmins() {
		String sql = "select * from admin order by admin_id desc";
		List<AdminVO> list = new ArrayList<AdminVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				AdminVO aVo = new AdminVO();
				aVo.setAdminId(rs.getString("admin_id"));
				aVo.setAdminPwd(rs.getString("admin_pwd"));
				aVo.setAuthority(rs.getInt("authority"));
			
				
				list.add(aVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertAdmin(AdminVO aVo) {				//
		String sql = "insert into admin("
				+ "admin_id, admin_pwd, authority ) "
				+ "values(admin_seq.nextval, ?, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getAdminPwd());
			pstmt.setInt(2, aVo.getAuthority());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String adminId) {
		String sql = "update admin set readcount=readcount+1 where admin_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public AdminVO selectOneAdminByAdminId(String adminId) {
		String sql = "select * from admin where admin_id = ?"; //
		AdminVO aVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				aVo = new AdminVO();
				aVo.setAdminId(rs.getString("admin_id"));
				aVo.setAdminPwd(rs.getString("admin_pwd"));
				aVo.setAuthority(rs.getInt("authority"));
				
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return aVo;
	}

	public void updateAdmin(AdminVO aVo) {
		String sql = "update admin set admin_pwd=?, authority=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getAdminPwd());
			pstmt.setInt(2, aVo.getAuthority());
		
			pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	 * public AdminVO checkPassWord(String pass, String adminId) { String sql =
	 * "select * from board where pass=? and num=?"; Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; AdminVO aVo = null; try
	 * { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setString(1, pass); pstmt.setString(2, adminId); rs =
	 * pstmt.executeQuery(); if (rs.next()) {
	 * aVo.setadminId(rs.getString("adminId"));
	 * aVo.setBoardTitle(rs.getString("boardTitle"));
	 * aVo.setBoardDate(rs.getDate("boardDate"));
	 * aVo.setBoardHits(rs.getInt("boardHits"));
	 * aVo.setBoardContents(rs.getString("boardContents"));
	 * aVo.setMemberId(rs.getString("memberId"));
	 * aVo.setAdminId(rs.getString("adminId")); }
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } return aVo; }
	 */

	public void deleteAdmin(String adminId) {
		String sql = "delete admin where admin_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
