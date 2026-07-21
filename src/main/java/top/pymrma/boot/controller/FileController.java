package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("file")
public class FileController {
    private final FileService fileService;
    @Value("${file.upload.dir}")
    private String uploadDir;

    //多文件上传
    @PostMapping("uploads/")
    public ResultMap<String> upload(MultipartFile[] files) throws IOException {
        fileService.upload(files);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    //单文件上传
    @PostMapping("upload")
    public ResultMap<String> upload(MultipartFile file) throws IOException {
        fileService.upload(file);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    @GetMapping("/{year}/{month}/{filename}")
    public ResponseEntity<byte[]> previewFile(
            @PathVariable String year,
            @PathVariable String month,
            @PathVariable String filename
    ) throws IOException {
        Path filePath = Paths.get(uploadDir, year, month, filename);
        File file = new File(filePath.toString());
        byte[] fileContent = Files.readAllBytes(file.toPath());
        String contentType = getContentType(filename);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));

        headers.setContentDisposition(ContentDisposition
                .builder("inline")
                .filename(filename, StandardCharsets.UTF_8)
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

        return switch (extension) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            case "gif" -> "image/gif";
            case "bmp" -> "image/bmp";
            case "webp" -> "image/webp";
            case "pdf" -> "application/pdf";
            case "doc" -> "application/msword";
            case "docx" -> "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "xls" -> "application/vnd.ms-excel";
            case "xlsx" -> "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "txt" -> "text/plain";
            case "mp4" -> "video/mp4";
            case "mp3" -> "audio/mpeg";
            default -> "application/octet-stream";
        };
    }
}
