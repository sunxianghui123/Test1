package component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//配置国际化视图解析器
public class MyLocalResolver implements LocaleResolver
{
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = Locale.getDefault();
        String str = request.getParameter("l");
        if(!StringUtils.isEmpty(str))
        {

           String[] s = str.split("_");
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.info(s[0]+s[1]);
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
