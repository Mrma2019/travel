package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.services.FileService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("file")
public class FileController {
    private final FileService fileService;

    @PostMapping("upload")
    public ResultMap upload(MultipartFile[] files) throws IOException {
        fileService.upload(files);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

}
