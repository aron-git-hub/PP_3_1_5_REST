package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public Role addRole(Role role) {
        roleDao.addRole(role);
        return role;
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Transactional
    @Override
    public Optional<Role> findByName(String name) {
        return roleDao.findByName(name);
    }
}