package com.it.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.BoardDAO;
import com.it.dto.BoardVO;


public class BoardUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		bVo.setBoardNo(request.getParameter("boardNo"));
		bVo.setBoardTitle(request.getParameter("boardTitle"));
		bVo.setBoardDate(request.getParameter("boardDate"));
		bVo.setBoardHits(Integer.parseInt(request.getParameter("boardHits")));
		bVo.setBoardContents(request.getParameter("boardContents"));
		bVo.setMemberId(request.getParameter("memberId"));
		bVo.setAdminId(request.getParameter("adminId"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		new BoardListAction().execute(request, response);
	}
}
