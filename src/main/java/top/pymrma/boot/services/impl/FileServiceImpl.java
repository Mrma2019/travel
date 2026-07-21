package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.PathMatcher;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.utils.DateUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final PathMatcher pathMatcher;
    @Value("${file.upload.dir}")
    private String uploadDir;

    private File fullPath;

    // 多文件上传
    @Override
    public List<String> upload(MultipartFile[] files) throws IOException {
        String destPath = getOrCreateDirectory();
        for (MultipartFile file : files) {
            String fileName = generateFileName(file);
            file.transferTo(new File(this.fullPath + File.separator + fileName));
        }
        return null;
    }

    //单文件上传
    @Override
    public String upload(MultipartFile file) throws IOException {
        String destPath = getOrCreateDirectory();
        String fileName = generateFileName(file);
        file.transferTo(new File(this.fullPath + File.separator + fileName));
        return destPath + fileName;
    }

    //创建目录
    public String getOrCreateDirectory() {
        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonth()).toLowerCase();

        if (uploadDir.endsWith(File.separator)) {
            uploadDir = uploadDir + File.separator;
        }

        String destPath = year + File.separator + month + File.separator;
        this.fullPath = new File(uploadDir + destPath);
        if (!this.fullPath.exists()) {
            boolean created = this.fullPath.mkdirs();
            if (!created) {
                log.error("目标目录创建失败！{}", destPath);
            }
        }

        return destPath;
    }

    //生成文件名
    public String generateFileName(MultipartFile file) {
        String currentDate = DateUtil.formatDate(new Date(System.currentTimeMillis()), "yyyyMMdd");
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "-" + currentDate + extension;

        return fileName;
    }


}
