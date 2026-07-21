package top.pymrma.boot.services;

import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.entity.File;

import java.io.IOException;
import java.util.List;

public interface FileService {

    boolean createFile(File file);

    List<String> upload(MultipartFile[] files) throws IOException;

    String upload(MultipartFile file) throws IOException;

}
