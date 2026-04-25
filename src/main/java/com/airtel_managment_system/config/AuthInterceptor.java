package com.airtel_managment_system.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        String uri = request.getRequestURI();

        if (uri.equals("/login")
                || uri.contains("/css")
                || uri.contains("/js")) {
            return true;
        }

        if (!loggedIn) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}