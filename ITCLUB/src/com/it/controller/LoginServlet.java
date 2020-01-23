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


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      
	   String url="login.jsp";
      
      HttpSession session= request.getSession();
      
      if(session.getAttribute("loginMember") !=null){//이미 로그인된 사용자면 
    	  url="main.jsp";//메인 페이지로 이동한다
      }
      
	   RequestDispatcher dispatcher = request
            .getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
   

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url="login.jsp";
            
            String memId= request.getParameter("memId");
      String memPwd= request.getParameter("memPwd");
      
      MemberDAO mDao= MemberDAO.getInstance();
      int result = mDao.memberCheck(memId, memPwd);
      
      if(result==1){
         MemberVO mVo= mDao.getMember(memId);
         HttpSession session = request.getSession();
         session.setAttribute("loginMember", mVo);
         request.setAttribute("message", "회원가입에 성공했습니다");
         url="main.jsp";
      }else if(result==0){
         request.setAttribute("message", "비밀번호가 맞지 않습니다 ");
      }else if(result==-1){
         request.setAttribute("message", "존재하지 않는 회원입니다 ");
      }
   RequestDispatcher dispatcher= request
         .getRequestDispatcher(url);
   dispatcher.forward(request, response);
   
   }
   


}