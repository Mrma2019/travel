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

    //多文件上传
    @PostMapping("uploads/")
    public ResultMap uploadFiles(MultipartFile[] files) throws IOException {
        fileService.upload(files);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    //单文件上传
    @PostMapping("upload")
    public ResultMap uploadFile(MultipartFile file) throws IOException {
        fileService.upload(file);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

}
