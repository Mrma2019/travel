package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.services.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@RestController
@RequiredArgsConstructor
@RequestMapping("file")
public class FileController {
    private final FileService fileService;

    //多文件上传
    @PostMapping("uploads/")
    public ResultMap upload(MultipartFile[] files) throws IOException {
        fileService.upload(files);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    //单文件上传
    @PostMapping("upload")
    public ResultMap upload(MultipartFile file) throws IOException {
        fileService.upload(file);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    @GetMapping("/{year}/{month}/{filename}")
    public ResponseEntity getFile(
            @PathVariable("year") String year,
            @PathVariable("month") String month,
            @PathVariable("filename") String filename
    ) throws IOException {
        String filePath = String.format("uploads/%s/%s/%s", year, month, filename);
        File file = new File(filePath);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        String contentType = getContentType(filename);

        // 6. 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));

        headers.setContentDisposition(ContentDisposition
                .builder("inline")  // 或 "attachment"
                .filename(filename, StandardCharsets.UTF_8)  // 支持中文文件名
                .build());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(fileContent);
    }

    private String getContentType(String filename) {
        if (filename == null) {
            return "application/octet-stream";
        }

        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

        switch (extension) {
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return "image/png";
            case "gif":
                return "image/gif";
            case "bmp":
                return "image/bmp";
            case "webp":
                return "image/webp";
            case "pdf":
                return "application/pdf";
            case "doc":
                return "application/msword";
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "xls":
                return "application/vnd.ms-excel";
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "txt":
                return "text/plain";
            case "mp4":
                return "video/mp4";
            case "mp3":
                return "audio/mpeg";
            default:
                return "application/octet-stream";
        }
    }
}
