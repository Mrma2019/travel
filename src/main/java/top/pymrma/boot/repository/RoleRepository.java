package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByCode(String code);
}
