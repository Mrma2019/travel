package top.pymrma.boot.vo;

import top.pymrma.boot.entity.Role;
import top.pymrma.boot.entity.User;

import java.util.List;
import java.util.Set;

public record UserVO(
         String username,
         String avatarUrl,
         String email,
         String bio,
         List<String> hobbies,
         User.Preferences preferences,
         String status,
         Set<Role> roles,
         String updatedAt,
         String createAt
) {
    
}
