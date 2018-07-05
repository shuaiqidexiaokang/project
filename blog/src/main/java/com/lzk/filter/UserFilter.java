package com.lzk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lzk on 2018/3/10 12:58
 * Description:
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(request.getRequestURI());
        String uri = request.getRequestURI();
        if (uri.equals("/blog/article/index")||uri.contains("details")){
            filterChain.doFilter(request,response);
        }
        if (username !=null){
            System.out.println(request.getRequestURI());
            System.out.println(request.getRequestURL());
            filterChain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath() +"/login1");
        }
    }

    @Override
    public void destroy() {

    }
}
