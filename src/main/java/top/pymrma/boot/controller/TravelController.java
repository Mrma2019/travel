package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.services.TravelService;

@RestController
@RequestMapping("travel")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;

    @PostMapping("add")
    public ResultMap addTravel(@RequestBody Travel travel) {
        boolean created = travelService.createTravel(travel);
        if (created) {
            return new ResultMap<>(ResultEnum.SUCCESS);
        } else {
            return new ResultMap<>(ResultEnum.DATABASE_ERROR);
        }
    }

    @GetMapping("all")
    public ResultMap queryAllTravels(@PageableDefault(size = 10) Pageable pageable) {
        return new ResultMap<>(ResultEnum.SUCCESS, travelService.queryAllTravels(pageable));
    }

}
