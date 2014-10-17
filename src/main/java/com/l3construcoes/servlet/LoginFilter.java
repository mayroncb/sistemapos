package com.l3construcoes.servlet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.l3construcoes.beans.LoginBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author paulolira
 */
public class LoginFilter implements Filter{

   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
       FilterChain chain  ) throws IOException, ServletException{
       
       LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
       if (loginBean != null && !loginBean.isLoggedIn()) { 
           String contextPath = ((HttpServletRequest)request).getContextPath();
           ((HttpServletResponse)response).sendRedirect(contextPath + "/login/login.xhtml"); 
       }
       if (chain != null && request != null && response != null ){
           chain.doFilter(request, response);
       }
       
   }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
       
    }
 
}