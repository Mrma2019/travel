package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    boolean existsUserByEmail(String email);

    boolean existsByEmail(String email);
}
