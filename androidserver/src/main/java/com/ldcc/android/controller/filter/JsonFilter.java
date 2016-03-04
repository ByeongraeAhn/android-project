package com.ldcc.android.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.do")
public class JsonFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    
    if (httpRequest.getServletPath().contains("/")) { //수정한거임
      HttpServletResponse httpResponse = (HttpServletResponse)response;
      httpResponse.setHeader("Access-Control-Allow-Origin", "*");
    }
    
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }

}
