package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.entity.File;
import top.pymrma.boot.properties.FileProperties;
import top.pymrma.boot.repository.FileRepository;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.utils.DateUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileProperties fileProperties;
    private java.io.File fullPath;

    @Override
    public boolean createFile(File file) {
        File savedFile = fileRepository.save(file);
        return savedFile.getId() != null;
    }

    // 多文件上传
    @Override
    public List<String> upload(MultipartFile[] files) throws IOException {
        List<String> destPathList = new ArrayList<>();
        for (MultipartFile file : files) {
            String destPath = getOrCreateDirectory();

            String fileName = generateFileName(file);
            Path path = Paths.get(fullPath.getPath(), fileName);
            file.transferTo(path);

            destPathList.add(destPath);
        }
        log.info("目标文件列表：{}", destPathList);
        return destPathList;
    }

    //单文件上传
    @Override
    public String upload(MultipartFile file) throws IOException {

        String fileName = generateFileName(file);
        String destPath = getOrCreateDirectory() + fileName;
        log.info("目标文件：{}", destPath);
        Path path = Paths.get(fullPath.getPath(), fileName);
        file.transferTo(path);

        return destPath;
    }

    //创建目录
    public String getOrCreateDirectory() {
        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonth()).toLowerCase();
        String uploadDir = fileProperties.getUploadDir();

        if (!uploadDir.endsWith(java.io.File.separator)) {
            uploadDir = uploadDir + java.io.File.separator;
        }

        String destPath = Paths.get(year, month) + java.io.File.separator;
        fullPath = new java.io.File(uploadDir + destPath);
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
        String extension = null;
        if (originalFilename != null) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "-" + currentDate + extension;

        return fileName;
    }

}
