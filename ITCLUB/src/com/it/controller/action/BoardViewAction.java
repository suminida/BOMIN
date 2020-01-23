package com.it.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.BoardDAO;
import com.it.dto.BoardVO;



public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/board/boardView.jsp";
		String boardNo = request.getParameter("boardNo");
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(boardNo);
		BoardVO bVo = bDao.selectOneBoardByNum(boardNo);
		request.setAttribute("board", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
