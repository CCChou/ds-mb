package ds.web.practice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginedAccount = (String) request.getSession().getAttribute("loginedAccount");
        if (loginedAccount == null) {
            response.sendRedirect(request.getContextPath() + "/verifyFail.jsp");
            return false;
        }
        return true;
    }
}
