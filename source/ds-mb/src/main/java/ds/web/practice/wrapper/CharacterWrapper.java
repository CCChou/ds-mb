package ds.web.practice.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterWrapper extends HttpServletRequestWrapper {

    public CharacterWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] params = super.getParameterValues(parameter);
        if (params == null) {
            return null;
        }

        String[] newParams = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            newParams[i] = params[i].replaceAll("\n", "<br>");
        }

        return newParams;
    }

    @Override
    public String getParameter(String parameter) {
        String param = super.getParameter(parameter);
        return param.replaceAll("\n", "<br>");
    }
}
