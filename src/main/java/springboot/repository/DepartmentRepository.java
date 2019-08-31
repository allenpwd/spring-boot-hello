package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springboot.entity.Department;

@Repository
@Component
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
