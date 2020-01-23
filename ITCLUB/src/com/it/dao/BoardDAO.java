package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.it.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from board order by board_no desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setBoardNo(rs.getString("board_no"));
				bVo.setBoardTitle(rs.getString("board_title"));
				bVo.setBoardDate(rs.getString("board_date"));
				bVo.setBoardHits(rs.getInt("board_hits"));
				bVo.setBoardContents(rs.getString("board_contents"));
				bVo.setMemberId(rs.getString("member_id"));
				bVo.setAdminId(rs.getString("admin_id"));
				
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(BoardVO bVo) {				//
		String sql = "insert into board("
				+ "board_no, board_title, board_hits, board_contents,member_id,admin_id,board_date ) "
				+ "values(board_seq.nextval,?, ?, ?, ?, ?, sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getBoardTitle());
			pstmt.setInt(2, bVo.getBoardHits());
			pstmt.setString(3, bVo.getBoardContents());
			pstmt.setString(4, bVo.getMemberId());
			pstmt.setString(5, bVo.getAdminId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String boardNo) {
		String sql = "update board set readcount=readcount+1 where board_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public BoardVO selectOneBoardByNum(String boardNo) {
		String sql = "select * from board where board_no = ?"; //
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new BoardVO();
				bVo.setBoardNo(rs.getString("board_no"));
				bVo.setBoardTitle(rs.getString("board_title"));
				bVo.setBoardDate(rs.getString("board_date"));
				bVo.setBoardHits(rs.getInt("board_hits"));
				bVo.setBoardContents(rs.getString("board_contents"));
				bVo.setMemberId(rs.getString("member_id"));
				bVo.setAdminId(rs.getString("admin_id"));
				
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(BoardVO bVo) {
		String sql = "update board set board_title=?, board_date=?, board_hits=?, "
				+ "board_contents=?, member_id=? where admin_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getBoardTitle());
			pstmt.setString(1, bVo.getBoardDate());
			pstmt.setInt(2, bVo.getBoardHits());
			pstmt.setString(3, bVo.getBoardContents());
			pstmt.setString(4, bVo.getMemberId());
			pstmt.setString(5, bVo.getAdminId());
			pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	 * public BoardVO checkPassWord(String pass, String boardNo) { String sql =
	 * "select * from board where pass=? and num=?"; Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; BoardVO bVo = null; try
	 * { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setString(1, pass); pstmt.setString(2, boardNo); rs =
	 * pstmt.executeQuery(); if (rs.next()) {
	 * bVo.setBoardNo(rs.getString("boardNo"));
	 * bVo.setBoardTitle(rs.getString("boardTitle"));
	 * bVo.setBoardDate(rs.getDate("boardDate"));
	 * bVo.setBoardHits(rs.getInt("boardHits"));
	 * bVo.setBoardContents(rs.getString("boardContents"));
	 * bVo.setMemberId(rs.getString("memberId"));
	 * bVo.setAdminId(rs.getString("adminId")); }
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } return bVo; }
	 */

	public void deleteBoard(String boardNo) {
		String sql = "delete board where board_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}