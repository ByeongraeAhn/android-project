package com.ldcc.android.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ldcc.android.domain.MemberVo;

public class LoginCheckInterceptor2 extends HandlerInterceptorAdapter {
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

   System.out.println("Interceptor : PreHandle");
   
   // Session userid check
   HttpSession session = request.getSession();   
   MemberVo member = (MemberVo)session.getAttribute("user");

   // Login false
   if(null==member) {
    System.out.println("Interceptor : Session Check Fail");
    // main page 로 이동
    response.sendRedirect("/androidserver/index.html");
    return false;
   } 
   // Login true
   else { 
    System.out.println("Interceptor : Session Check true");
    return super.preHandle(request, response, handler);
   }
  }
 }