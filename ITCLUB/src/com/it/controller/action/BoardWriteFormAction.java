package com.it.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.BoardDAO;
import com.it.dto.BoardVO;

public class BoardWriteFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//String url = "/board/boardWrite.jsp";
		BoardVO bVo = new BoardVO();
		 bVo.setBoardTitle(request.getParameter("boardTitle"));
		// bVo.setBoardDate(request.getParameter("boardDate"));
		 bVo.setBoardHits(Integer.parseInt(request.getParameter("boardHits")));
		 bVo.setBoardContents(request.getParameter("boardContents"));
		 bVo.setMemberId(request.getParameter("memberId"));
		 bVo.setAdminId(request.getParameter("adminId"));
		 
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);new BoardListAction().execute(request, response);
		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		 * dispatcher.forward(request,response);
		 */
	}
	
	

}
