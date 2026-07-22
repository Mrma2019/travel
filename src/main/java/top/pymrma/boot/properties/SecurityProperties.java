package top.pymrma.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private String[] whitelist;
    private String[] auth;
}