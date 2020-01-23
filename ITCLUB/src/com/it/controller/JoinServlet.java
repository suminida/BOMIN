package com.it.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.dao.MemberDAO;
import com.it.dto.MemberVO;

/**
 * Servlet implementation class JoinServlet
 */

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    
   protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher dispatcher = request
            .getRequestDispatcher("member/join.jsp");
      dispatcher.forward(request, response);
   }
   


   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      String memId= request.getParameter("memId");
      String memName= request.getParameter("memName");
      String memPwd= request.getParameter("memPwd");
      String emPhone= request.getParameter("memPhone");
      String memEmail= request.getParameter("memEmail");
      String memAuth= request.getParameter("memAuth");
      String adminId= request.getParameter("adminId");
      
      MemberVO mVo=new MemberVO();
      mVo.setMemId(memId);
      mVo.setMemName(memName);
      mVo.setMemPwd(memPwd);
      mVo.setMemPhone(emPhone);
      mVo.setMemEmail(memEmail);
      mVo.setMemPhone(memAuth);
      mVo.setMemEmail(adminId);
      
      
      MemberDAO mDao= MemberDAO.getInstance();
      int result=mDao.insertMember(mVo);
      
      HttpSession sesstion = request.getSession();
   
      if(result==1){
    	  sesstion.setAttribute("memberId",mVo.getMemId());
    	  request.setAttribute("message", "회원가입에 성공했습니다");
      }else {
    	  request.setAttribute("message", "회원 가입에 실패했습니다");
      }
      
      RequestDispatcher dispatcher = request
    		  .getRequestDispatcher("member/login.jsp");
      dispatcher.forward(request, response);
   }
  
}

