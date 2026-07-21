package top.pymrma.boot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    boolean createFile(MultipartFile file) throws IOException;

    List<String> upload(MultipartFile[] files) throws IOException;

    String upload(MultipartFile file) throws IOException;

}
