package top.pymrma.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.pymrma.boot.entity.Photo;
import top.pymrma.boot.vo.PhotoVO;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Page<Photo> findPhotoByTravelId(Pageable pageable, Long travelId);
}
