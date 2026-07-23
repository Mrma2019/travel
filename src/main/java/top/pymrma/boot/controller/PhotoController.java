package top.pymrma.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.PageQueryDTO;
import top.pymrma.boot.entity.Photo;
import top.pymrma.boot.services.PhotoService;

import java.io.IOException;

@RestController
@RequestMapping("photo")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;
    private final ObjectMapper objectMapper;

    @PostMapping("add")
    public ResultMap<String> createPhotos(@RequestPart("photos") String photoJson, @RequestPart("files") MultipartFile[] files) throws IOException {
        Photo photos = objectMapper.readValue(photoJson, Photo.class);
        boolean created = photoService.createPhotos(photos, files);

        return created ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);
    }

    @PostMapping("query/all")
    public ResultMap<PageResult> queryAllPhotos(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(
                ResultEnum.SUCCESS,
                photoService.queryAllPhotos(queryDTO.toPageable())
        );
    }

    @PostMapping("query/{travelId}")
    public ResultMap<PageResult> queryPhotosByTravelId(@PathVariable Long travelId, @RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(
                ResultEnum.SUCCESS,
                photoService.queryPhotosByTravelId(queryDTO.toPageable(), travelId)
        );
    }
}
