package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
}
