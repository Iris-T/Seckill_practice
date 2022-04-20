package cn.iris.seckill.config;

import cn.iris.seckill.pojo.User;
import org.springframework.core.MethodParameter;
import org.springframework.messaging.Message;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author Iris 2022/4/20
 */
@Component
public class UserArgResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(org.springframework.core.MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return UserContext.getUser();
    }
}