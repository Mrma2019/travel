package top.pymrma.boot.services;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.Photo;
import top.pymrma.boot.vo.PhotoVO;

import java.io.IOException;

public interface PhotoService {
    boolean createPhotos(Photo photo, MultipartFile[] files) throws IOException;

    PageResult<PhotoVO> queryAllPhotos(Pageable pageable);
}
