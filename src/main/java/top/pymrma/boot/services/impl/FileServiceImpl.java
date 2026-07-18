package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.utils.DateUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    @Override
    public boolean upload(MultipartFile[] files) throws IOException {
        String currentDate = DateUtil.formatDate(new Date(System.currentTimeMillis()), "yyyyMMdd");

        File destPath = new File(uploadDir + currentDate);
        if (!destPath.exists()) {
            boolean created = destPath.mkdirs();
            if (!created) {
                log.error("目标目录创建失败！{}", destPath);
            }
        }

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "-" + currentDate + extension;

            file.transferTo(new File(destPath + File.separator + fileName));
        }
        return false;
    }

    @Override
    public void download() {

    }
}
