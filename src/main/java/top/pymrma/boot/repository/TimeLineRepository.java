package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.pymrma.boot.entity.TimeLine;

public interface TimeLineRepository extends JpaRepository<TimeLine, Long> {
}
