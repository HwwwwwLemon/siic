package com.hwwwww.siic.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hwwwww.siic.utils.TokenUtil;
import com.hwwwww.siic.utils.WebCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hwwwww
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
                log.info("Token验证通过!");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("msg", "Token verify fail");
            json.put("code", WebCode.TOKEN_VERIFY_FAILED);
            response.getWriter().append(json.toJSONString());
/*            System.out.print(request.getRequestURL());
            System.out.println("Token认证失败，验证未通过!");*/
            log.error("请求:" + request.getRequestURI() + ",Token认证失败，验证未通过!");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}