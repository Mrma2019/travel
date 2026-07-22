package top.pymrma.boot.vo;

import lombok.Data;
import top.pymrma.boot.entity.Role;
import top.pymrma.boot.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class UserVO {
    private String username;
    private String avatarUrl;
    private String email;
    private String bio;
    private List<String> hobbies;
    private User.Preferences preferences;
    private String status;
    private Set<Role> roles;
    private String updatedAt;
    private String createAt;
}
