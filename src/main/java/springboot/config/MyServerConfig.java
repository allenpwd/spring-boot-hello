package springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.filter.MyFilter;
import springboot.listener.MyListener;
import springboot.servlet.MyServlet;

import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    /**
     * ServletListenerRegistrationBean能看到支持注册的listener
 *          Set<Class<?>> types = new HashSet<>();
     * 		types.add(ServletContextAttributeListener.class);
     * 		types.add(ServletRequestListener.class);
     * 		types.add(ServletRequestAttributeListener.class);
     * 		types.add(HttpSessionAttributeListener.class);
     * 		types.add(HttpSessionListener.class);
     * 		types.add(ServletContextListener.class);
     * 		SUPPORTED_TYPES = Collections.unmodifiableSet(types);
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

}
