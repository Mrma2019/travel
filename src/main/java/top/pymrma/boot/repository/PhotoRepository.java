package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
