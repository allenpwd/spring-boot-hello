package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.entity.Department;
import springboot.entity.User;
import springboot.repository.DepartmentRepository;
import springboot.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author pwd
 * @create 2019-01-31 10:27
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private UserRepository userRepository;

    @RequestMapping("hello")
    @ResponseBody
    public Object hello(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "潘伟丹");
        map.put("msg", "hello world!");
        return map;
    }

    @RequestMapping("/thymeleaf")
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        List<User> list = userRepository.findAll();
        req.setAttribute("user", list.get(0));
        req.setAttribute("html", "<h1>带<span style='color:red;'>html</span>标签的文本</h1>");
        return "thymeleaf";
    }
}
