package top.pymrma.boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.Travel;

public interface TravelService {
    boolean createTravel(Travel travel);

    PageResult<Travel> queryAllTravels(Pageable pageable);

    boolean deleteById(Long id);
}
