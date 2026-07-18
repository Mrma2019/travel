package top.pymrma.boot.services;

import top.pymrma.boot.entity.Role;

public interface RoleService {
    boolean isExists(String code);

    boolean createRole(Role role);

    boolean deleteRole(Long id);
}
