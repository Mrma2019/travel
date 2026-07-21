package top.pymrma.boot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    boolean createFile(MultipartFile file) throws IOException;

    void upload(MultipartFile[] files) throws IOException;

    void upload(MultipartFile file) throws IOException;

    void download() throws IOException;
}
