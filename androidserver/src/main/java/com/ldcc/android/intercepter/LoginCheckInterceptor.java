package com.ldcc.android.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.ldcc.android.domain.MemberVo;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  
        HttpSession session  = request.getSession(false);
  
        if(session == null) {
            response.sendRedirect(request.getContextPath()+"/login.do");  
            return false;
        }
  
        MemberVo member = (MemberVo)session.getAttribute("user");
  
        if (member == null) {
            response.sendRedirect(request.getContextPath()+"/login.do");  
            return false;
        }
          
        return true;  
    }  
}