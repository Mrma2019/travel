package top.pymrma.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.PageQueryDTO;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.services.TravelService;

import java.io.IOException;

@RestController
@RequestMapping("travel")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;
    private final ObjectMapper objectMapper;

    @PostMapping("add")
    public ResultMap<String> addTravel(@RequestPart("travel") String travelJson, @RequestPart("file") MultipartFile file) throws IOException {
        Travel travel = objectMapper.readValue(travelJson, Travel.class);
        boolean created = travelService.createTravel(travel, file);
        return created ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);

    }

    @PostMapping("query/all")
    public ResultMap<PageResult> queryAllTravels(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(ResultEnum.SUCCESS, travelService.queryAllTravels(queryDTO.toPageable()));
    }

    @GetMapping("del/{id}")
    public ResultMap<String> delTravel(@PathVariable Long id) {
        boolean deleted = travelService.deleteById(id);
        return deleted ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);
    }

}
