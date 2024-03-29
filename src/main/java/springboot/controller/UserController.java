package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.entity.Department;
import springboot.entity.User;
import springboot.exception.UserNotExistException;
import springboot.repository.DepartmentRepository;
import springboot.repository.UserRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    //查询所有员工返回列表页面
    @GetMapping("/users")
    public String  list(Model model){
        Collection<User> users = userRepository.findAll();

        //放在请求域中
        model.addAttribute("users",users);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    //来到员工添加页面
    @GetMapping("")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentRepository.findAll();
        model.addAttribute("depts",departments);
        return "user/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("")
    public String addEmp(User user){
        //来到员工列表页面

        user.setCreateDate(new Date());
        System.out.println("保存的员工信息：" + user);
        //保存员工
        userRepository.save(user);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/user/users";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentRepository.findAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("")
    public String updateEmployee(User user){
        System.out.println("修改的员工数据："+ user);
        userRepository.save(user);
        return "redirect:/user/users";
    }

    //员工删除
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/user/users";
    }

    @RequestMapping("/testError")
    public String testError(@RequestParam("user")String user) {
        if ("error".equals(user)) {
            throw new UserNotExistException();
        }
        return "/user/list";
    }

}
