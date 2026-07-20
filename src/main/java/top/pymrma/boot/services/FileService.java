package top.pymrma.boot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    boolean createFile(MultipartFile file) throws IOException;

    boolean upload(MultipartFile[] files) throws IOException;

    boolean upload(MultipartFile file) throws IOException;

    void download() throws IOException;
}
