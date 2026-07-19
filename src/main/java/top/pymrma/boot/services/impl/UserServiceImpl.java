package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.converter.UserConverter;
import top.pymrma.boot.dto.RegisterDTO;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.repository.UserRepository;
import top.pymrma.boot.services.EmailService;
import top.pymrma.boot.services.UserService;
import top.pymrma.boot.vo.UserVO;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final UserConverter userConverter;

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail((email));
    }

    @Transactional
    @Override
    public boolean register(RegisterDTO dto) {
        String encode = passwordEncoder.encode(dto.getPassword());
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encode);
        User savedUser = userRepository.save(user);
        if (savedUser.getId() != null) {
            log.info("注册用户-->email：{}", user.getEmail());
            emailService.sendSimpleEamil(user.getEmail(), "travel-memory", "欢迎使用专属你的旅行相册");
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean createUser(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        User savedUser = userRepository.save(user);
        return savedUser.getId() != null;
    }

    @Override
    public PageResult<UserVO> queryAllUser(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        Page<UserVO> map = page.map(userConverter::toVO);
        return PageResult.of(map);
    }
}
