package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.entity.Department;
import springboot.repository.DepartmentRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author pwd
 * @create 2019-01-31 11:14
 **/
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping("/{id}")
    @ResponseBody
    public Object createDepartment(@PathVariable("id") Long id, @RequestParam("name") String name, HttpServletRequest req) {
        Department department = new Department();
        department.setName(name);
        department.setId(id);

        Optional<Department> byId = departmentRepository.findById(4L);
        Department department1 = byId.get();
        System.out.println(department1 == null);
        ServletContext context = req.getServletContext();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("dept", department1);
        return resultMap;
    }

}
