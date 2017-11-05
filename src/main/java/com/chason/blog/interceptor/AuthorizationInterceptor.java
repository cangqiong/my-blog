//package com.chason.blog.interceptor;
//
//import com.chason.blog.annotation.Authorization;
//import com.chason.blog.model.BlogUser;
//import com.chason.blog.service.IUserService;
//import com.chason.blog.util.JwtTokenUtil;
//import io.jsonwebtoken.ExpiredJwtException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
///**
// * 自定义拦截器，验证用户请求释放有权限
// *
// * @author cang
// * @date 2017-10-08
// */
//@Component
//public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Value("${jwt.header}")
//    private String jwtHeaderPrefix;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private IUserService blogUserService;
//
//    public boolean isNeedAuthorization(Object handler) {
//
//        // 如果不是映射到方法直接通过
//        if (!(handler instanceof HandlerMethod)) {
//            return false;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//
//        if (method.getAnnotation(Authorization.class) != null) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        if (!isNeedAuthorization(handler)) {
//            return true;
//        }
//
//        String jwtRequestHeader = request.getHeader(jwtHeaderPrefix);
//
//        String authToken = null;
//        String username = null;
//
//        if (jwtRequestHeader != null && jwtRequestHeader.startsWith("Bearer ")) {
//            authToken = jwtRequestHeader.substring(7);
//            try {
//                username = jwtTokenUtil.getUsernameFromToken(authToken);
//            } catch (IllegalArgumentException e) {
//                logger.error("an error occured during getting username from token", e);
//            } catch (ExpiredJwtException e) {
//                logger.warn("the token is expired and not valid anymore", e);
//            }
//        } else {
//            logger.warn("couldn't find bearer string, will ignore the header");
//        }
//
//        logger.info("checking authentication for user " + username);
//
//        if (username != null) {
//
//            BlogUser user = blogUserService.findByUsername(username);
//
//            if (jwtTokenUtil.validateToken(authToken, user)) {
//                return true;
//            }
//        }
//
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        return false;
//
////        throw new NotLoginException(SystemConstantEnum.NOT_LOGIN.getCode(), SystemConstantEnum.NOT_LOGIN.getMsg());
//
//    }
//}
