package top.pymrma.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
}
