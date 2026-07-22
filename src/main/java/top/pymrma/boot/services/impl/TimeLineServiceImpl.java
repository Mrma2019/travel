package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.TimeLine;
import top.pymrma.boot.repository.TimeLineRepository;
import top.pymrma.boot.services.TimeLineService;

@Service
@RequiredArgsConstructor
public class TimeLineServiceImpl implements TimeLineService {

    private final TimeLineRepository timeLineRepository;

    @Override
    public boolean createTimeLine(TimeLine timeLine) {
        TimeLine savedTimeLine = timeLineRepository.save(timeLine);
        return savedTimeLine.getId() != null;
    }

    @Override
    public PageResult<TimeLine> queryAllTimeLine(Pageable pageable) {
        Page<TimeLine> timeLinePage = timeLineRepository.findAll(pageable);
        return PageResult.of(timeLinePage);
    }
}
