package top.pymrma.boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.Travel;

import java.io.IOException;

public interface TravelService {
    boolean createTravel(Travel travel, MultipartFile file) throws IOException;

    PageResult<Travel> queryAllTravels(Pageable pageable);

    boolean deleteById(Long id);
}
