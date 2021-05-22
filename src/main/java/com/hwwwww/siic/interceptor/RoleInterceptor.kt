package com.hwwwww.siic.interceptor

import com.alibaba.fastjson.JSONObject
import com.hwwwww.siic.service.impl.RoleServiceImpl
import com.hwwwww.siic.utils.MyLogger
import com.hwwwww.siic.utils.WebCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
open class RoleInterceptor : HandlerInterceptor {
    @Autowired
    private lateinit var service: RoleServiceImpl

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        //Todo:根据请求的id获取权限
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json; charset=utf-8"
        val json = JSONObject()
        if ("OPTIONS" == request.method) {
            response.status = HttpServletResponse.SC_OK
            return true
        }
        val userId = request.getHeader("userId")
        println(request.requestURI)

        if (service.checkRoles(userId.toInt(), request.requestURI)){
            return true
        }

        try {
            json["message"] = "Sorry, you do not have permission to access"
            json["code"] = WebCode.NO_PERMISSION
            response.writer.append(json.toJSONString())
            MyLogger.error("请求:" + request.requestURI + ",没有权限访问，验证未通过!")
        } catch (e: Exception) {
            e.printStackTrace()
            response.sendError(500)
        }

        return false
    }
}