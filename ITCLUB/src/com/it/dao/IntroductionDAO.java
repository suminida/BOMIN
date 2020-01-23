package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.it.dto.IntroductionVO;

import util.DBManager;

public class IntroductionDAO {
	private IntroductionDAO() {
	}

	private static IntroductionDAO instance = new IntroductionDAO();

	public static IntroductionDAO getInstance() {
		return instance;
	}

	public List<IntroductionVO> selectAllIntroductions() {
		String sql = "select * from introduction order by intro_no desc";
		List<IntroductionVO> list = new ArrayList<IntroductionVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				IntroductionVO iVo = new IntroductionVO();
				iVo.setIntroNo(rs.getString("intro_no"));
				iVo.setIntroName(rs.getString("intro_name"));
				iVo.setIntroContents(rs.getString("intro_contents"));
				iVo.setIntroHistory(rs.getString("intro_history"));
				iVo.setAdminId(rs.getString("admin_id"));
				
				list.add(iVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertIntroduction(IntroductionVO iVo) {				//
		String sql = "insert into introduction("
				+ "intro_no, intro_name, intro_contents, intro_history, admin_id) "
				+ "values(introduction_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iVo.getIntroName());
			pstmt.setString(2, iVo.getIntroContents());
			pstmt.setString(3, iVo.getIntroHistory());
			pstmt.setString(4, iVo.getAdminId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String introNo) {
		String sql = "update introduction set readcount=readcount+1 where intro_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, introNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public IntroductionVO selectOneIntroductionByNum(String introNo) {
		String sql = "select * from introduction where intro_no = ?"; //
		IntroductionVO iVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, introNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				iVo = new IntroductionVO();
				iVo.setIntroNo(rs.getString("intro_no"));
				iVo.setIntroName(rs.getString("intro_name"));
				iVo.setIntroContents(rs.getString("intro_contents"));
				iVo.setIntroHistory(rs.getString("intro_history"));
				iVo.setAdminId(rs.getString("admin_id"));
				
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return iVo;
	}

	public void updateIntroduction(IntroductionVO iVo) {
		String sql = "update introduction set intro_name=?, intro_contents=?, intro_history=?, admin_id=?, " ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iVo.getIntroName());
			pstmt.setString(2, iVo.getIntroContents());
			pstmt.setString(3, iVo.getIntroHistory());
			pstmt.setString(4, iVo.getAdminId());
			pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	 * public IntroductionVO checkPassWord(String pass, String boardNo) { String sql =
	 * "select * from board where pass=? and num=?"; Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; IntroductionVO iVo = null; try
	 * { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setString(1, pass); pstmt.setString(2, boardNo); rs =
	 * pstmt.executeQuery(); if (rs.next()) {
	 * iVo.setBoardNo(rs.getString("boardNo"));
	 * iVo.setBoardTitle(rs.getString("boardTitle"));
	 * iVo.setBoardDate(rs.getDate("boardDate"));
	 * iVo.setBoardHits(rs.getInt("boardHits"));
	 * iVo.setBoardContents(rs.getString("boardContents"));
	 * iVo.setMemberId(rs.getString("memberId"));
	 * iVo.setAdminId(rs.getString("adminId")); }
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } return iVo; }
	 */

	public void deleteIntroduction(String introNo) {
		String sql = "delete introduction where intro_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, introNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}