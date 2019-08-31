package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
