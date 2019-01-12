package cn.monk.news.Config;

import cn.monk.news.interceptor.LoginRequiredInterceptor;
import cn.monk.news.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Created by 和尚 on 2019/1/12.
 */
@Component
public class newswebconfig  implements WebMvcConfigurer {
    @Autowired
    private PassportInterceptor passportInterceptor;
    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/msg/**");
    }
}
