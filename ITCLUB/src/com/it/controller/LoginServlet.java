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
      
      if(session.getAttribute("loginMember") !=null){//�̹� �α��ε� ����ڸ� 
    	  url="main.jsp";//���� �������� �̵��Ѵ�
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
         request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�");
         url="main.jsp";
      }else if(result==0){
         request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ� ");
      }else if(result==-1){
         request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ� ");
      }
   RequestDispatcher dispatcher= request
         .getRequestDispatcher(url);
   dispatcher.forward(request, response);
   
   }
   


}