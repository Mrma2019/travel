package top.pymrma.boot.converter.utils;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import top.pymrma.boot.properties.FileProperties;

@Component
@RequiredArgsConstructor
public class FileUrlResolver {
    private final FileProperties fileProperties;

    @Named("toUrl")
    public String toUrl(String coverUrl) {
        if (coverUrl == null) {
            return null;
        }
        return fileProperties.getDomain() + coverUrl.replace("\\", "/");
    }
}
