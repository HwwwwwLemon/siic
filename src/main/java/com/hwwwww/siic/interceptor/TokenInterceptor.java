package com.hwwwww.siic.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hwwwww.siic.utils.MyLogger;
import com.hwwwww.siic.utils.TokenUtil;
import com.hwwwww.siic.utils.WebCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hwwwww
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtil tokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        Integer code = WebCode.TOKEN_ILLEGAL;
        JSONObject json = new JSONObject();
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token != null) {
            try {
                boolean result = tokenUtil.verify(token);
                if (result) {
                    MyLogger.info("请求:" + request.getRequestURI() + ",Token认证成功，验证通过!");
                    return true;
                }
            } catch (TokenExpiredException e) {
                code = WebCode.TOKEN_EXPIRED;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            json.put("message", "Token verify fail");
            json.put("code", code);
            response.getWriter().append(json.toJSONString());
            MyLogger.error("请求:" + request.getRequestURI() + ",Token认证失败，验证未通过!");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
        return false;
    }
}