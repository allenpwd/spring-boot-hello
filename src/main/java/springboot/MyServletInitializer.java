package springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springboot.main.Application;

/**
 * @author 门那粒沙
 * @create 2019-08-31 20:41
 **/
public class MyServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //传入springboot应用的主程序
        return builder.sources(Application.class);
    }
}
