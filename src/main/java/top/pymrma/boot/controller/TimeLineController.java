package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.PageQueryDTO;
import top.pymrma.boot.entity.TimeLine;
import top.pymrma.boot.services.TimeLineService;

@RestController
@RequestMapping("time-line")
@RequiredArgsConstructor
public class TimeLineController {

    private final TimeLineService timeLineService;

    @PostMapping("add")
    public ResultMap<String> createTimeLine(@RequestBody TimeLine timeLine) {
        boolean created = timeLineService.createTimeLine(timeLine);
        return created ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);
    }

    @PostMapping("query/all")
    public ResultMap<PageResult> queryAllTimeLine(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(ResultEnum.SUCCESS, timeLineService.queryAllTimeLine(queryDTO.toPageable()));
    }
}
