package com.yaomy.sgrain.returnvalue.handler;

import com.yaomy.sgrain.common.enums.HttpStatus;
import com.yaomy.sgrain.common.po.BaseResponse;
import com.yaomy.sgrain.common.utils.RouteUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 控制器返回返回值包装类,处理带@ResponseBody标识的返回值类型
 * @Version: 1.0
 */
public class ResponseMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private HandlerMethodReturnValueHandler proxyObject;

    public ResponseMethodReturnValueHandler(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ResponseBody.class) ||
                returnType.hasMethodAnnotation(ResponseBody.class));
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        //标注该请求已经在当前处理程序处理过
        mavContainer.setRequestHandled(true);
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if(RouteUtils.readRoute().contains(request.getRequestURI())){
            proxyObject.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
        } else if(null != returnValue && (returnValue instanceof BaseResponse)){
            proxyObject.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
        } else {
            Map<String, Object> resultMap = new LinkedHashMap<>();
            resultMap.put("status", HttpStatus.OK.getStatus());
            resultMap.put("message", HttpStatus.OK.getMessage());
            //返回值为void类型的data字段不输出
            if(!returnType.getMethod().getReturnType().equals(Void.TYPE)){
                resultMap.put("data", returnValue);
            }
            proxyObject.handleReturnValue(resultMap, returnType, mavContainer, webRequest);
        }
    }

}
