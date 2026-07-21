package top.pymrma.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping("add")
    public ResultMap addTravel(@RequestParam("travel") String travelJson, @RequestParam("file") MultipartFile file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Travel travel = objectMapper.readValue(travelJson, Travel.class);

        boolean created = travelService.createTravel(travel, file);
        if (created) {
            return new ResultMap<>(ResultEnum.SUCCESS);
        } else {
            return new ResultMap<>(ResultEnum.DATABASE_ERROR);
        }
    }

    @PostMapping("all")
    public ResultMap queryAllTravels(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(ResultEnum.SUCCESS, travelService.queryAllTravels(queryDTO.toPageable()));
    }

    @GetMapping("del/{id}")
    public ResultMap delTravel(@PathVariable Long id) {
        boolean deleted = travelService.deleteById(id);
        return deleted ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);
    }

}
