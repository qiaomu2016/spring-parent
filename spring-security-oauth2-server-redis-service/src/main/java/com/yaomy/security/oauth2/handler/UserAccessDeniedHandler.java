package com.yaomy.security.oauth2.handler;

import com.yaomy.sgrain.common.po.BaseResponse;
import com.yaomy.sgrain.common.utils.json.JSONUtils;
import com.yaomy.sgrain.common.enums.HttpStatusMsg;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 用来解决认证过的用户访问无权限资源时的异常
 * @ProjectName: spring-parent
 * @Package: com.yaomy.security.handler.AjaxAccessDeniedHandler
 * @Date: 2019/7/1 15:34
 * @Version: 1.0
 */
@Component
public class UserAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        JSONUtils.writeValue(response.getOutputStream(), BaseResponse.createResponse(HttpStatusMsg.ACCESS_DENIDED_EXCEPTION.getStatus(), HttpStatusMsg.ACCESS_DENIDED_EXCEPTION.getMessage()+","+e.toString()));
    }
}
