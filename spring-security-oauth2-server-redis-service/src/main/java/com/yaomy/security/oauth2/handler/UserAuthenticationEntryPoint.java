package com.yaomy.security.oauth2.handler;

import com.yaomy.sgrain.common.po.BaseResponse;
import com.yaomy.sgrain.common.utils.json.JSONUtils;
import com.yaomy.sgrain.common.enums.HttpStatusMsg;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 用来解决匿名用户访问无权限资源时的异常
 * @ProjectName: spring-parent
 * @Package: com.yaomy.security.handler.AjaxAuthenticationEntryPoint
 * @Date: 2019/7/1 15:36
 * @Version: 1.0
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JSONUtils.writeValue(response.getOutputStream(), BaseResponse.createResponse(HttpStatusMsg.AUTHENTICATION_EXCEPTION.getStatus(), HttpStatusMsg.AUTHENTICATION_EXCEPTION.getMessage()+","+e.toString()));

    }
}
