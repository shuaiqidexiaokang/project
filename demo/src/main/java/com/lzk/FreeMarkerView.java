package com.lzk;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lzk
 * @create 2018-08-20 23:48
 * Description:
 */
public class FreeMarkerView extends org.springframework.web.servlet.view.freemarker.FreeMarkerView {
    private static final String CONTEXT_PATH = "base";
    @Override
    protected void exposeHelpers(Map<String, Object> model,
                                 HttpServletRequest request) throws Exception {
        model.put(CONTEXT_PATH, request.getContextPath());
        super.exposeHelpers(model, request);
    }

}
