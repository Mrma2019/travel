package top.pymrma.boot.services;

import top.pymrma.boot.dto.RegisterDTO;
import top.pymrma.boot.entity.User;

import java.util.List;

public interface UserService {
    boolean isExists(String email);

    void register(RegisterDTO dto);

    void createUser(User user);

    List<User> queryAllUser();
}
