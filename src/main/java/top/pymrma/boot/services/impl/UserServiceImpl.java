package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.dto.RegisterDTO;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.repository.UserRepository;
import top.pymrma.boot.services.EmailService;
import top.pymrma.boot.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public boolean isExists(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Transactional
    @Override
    public void register(RegisterDTO dto) {
        String encode = passwordEncoder.encode(dto.getPassword());
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encode);
        User saved = userRepository.save(user);
        if (saved.getId() != null) {
            emailService.sendSimpleEamil(user.getEmail(), "travel-memory", "欢迎使用专属你的旅行相册");
        }
    }

    @Transactional
    @Override
    public void createUser(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        userRepository.save(user);
    }

    @Override
    public PageResult<User> findPage(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return PageResult.of(page);
    }
}
