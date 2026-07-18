package top.pymrma.boot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    boolean upload(MultipartFile[] files) throws IOException;

    void download();
}
