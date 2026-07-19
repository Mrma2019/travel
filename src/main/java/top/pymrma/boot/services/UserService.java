package top.pymrma.boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.dto.RegisterDTO;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.vo.UserVO;

import java.util.List;

public interface UserService {
    boolean isExists(String email);

    void register(RegisterDTO dto);

    void createUser(User user);

    PageResult<UserVO> findPage(Pageable pageable);
}
