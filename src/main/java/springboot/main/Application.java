package springboot.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.config.MyConfig;
import springboot.entity.Department;
import springboot.entity.User;
import springboot.repository.DepartmentRepository;
import springboot.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@ComponentScan({"springboot.controller","springboot.config", "springboot.component", "springboot.repository."})
public class Application {

    @Value("${server.port}")
    String serverPort;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {

        //SpringApplication.run(Application.class, args);
        SpringApplication.run(new Class[]{MyConfig.class, Application.class}, args);
    }

}
