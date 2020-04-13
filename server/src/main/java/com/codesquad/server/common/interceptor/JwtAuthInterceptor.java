package com.codesquad.server.common.interceptor;

import com.codesquad.server.domain.service.JwtUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtAuthInterceptor implements HandlerInterceptor {

    @NonNull
    private JwtUtil jwtUtil;

    private Logger logger = LoggerFactory.getLogger(JwtAuthInterceptor.class);

    private String token = "123";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUserToken = request.getHeader("token");
        verifyToken(token, requestUserToken);
        return true;
    }

    private void verifyToken(String token, String requestUserToken) {
        if (!token.equals(requestUserToken)) {
            throw new IllegalArgumentException("잘못된 토큰 입니다!");
        }
        jwtUtil.verifyToken(requestUserToken);
    }
}
