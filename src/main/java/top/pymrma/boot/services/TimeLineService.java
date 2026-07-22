package top.pymrma.boot.services;

import org.springframework.data.domain.Pageable;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.TimeLine;

public interface TimeLineService {
    boolean createTimeLine(TimeLine timeLine);

    PageResult<TimeLine> queryAllTimeLine(Pageable pageable);
}
