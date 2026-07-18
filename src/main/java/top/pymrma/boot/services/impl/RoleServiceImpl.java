package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.pymrma.boot.entity.Role;
import top.pymrma.boot.repository.RoleRepository;
import top.pymrma.boot.services.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public boolean isExists(String code) {
        Role role = roleRepository.findRoleByCode(code);
        return role != null;
    }

    @Transactional
    @Override
    public boolean createRole(Role role) {
        if (isExists(role.getCode())) {
            return false;
        }
        role.setCode(role.getCode().toUpperCase());
        Role saved = roleRepository.save(role);
        return true;
    }

    @Override
    public boolean deleteRole(Long id) {
        return false;
    }
}
