package cn.iris.seckill.config;

import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IUserService;
import cn.iris.seckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iris 2022/4/20
 */
@Component
public class UserArgResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private IUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest req = (HttpServletRequest) webRequest.getNativeRequest();
        HttpServletResponse resp = (HttpServletResponse) webRequest.getNativeResponse();
        String ticket = CookieUtil.getCookieValue(req, "UserLoginTicket");

        if (ObjectUtils.isEmpty(ticket)) {
            return null;
        }

        return userService.getUserByCookie(ticket, req, resp);
    }
}
