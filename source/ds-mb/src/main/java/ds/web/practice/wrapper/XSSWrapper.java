package ds.web.practice.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.util.HtmlUtils;

public class XSSWrapper extends HttpServletRequestWrapper {
    public XSSWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] params = super.getParameterValues(parameter);
        if(params == null) {
            return null;
        }
        
        String[] newParams = new String[params.length];
        for(int i=0; i<params.length; i++) {
            newParams[i] = HtmlUtils.htmlEscape(params[i]);
        }
        
        return newParams;
    }

    @Override
    public String getParameter(String parameter) {
        String param = super.getParameter(parameter);
        return HtmlUtils.htmlEscape(param);
    }
}
