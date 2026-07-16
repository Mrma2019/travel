package top.pymrma.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }
}
