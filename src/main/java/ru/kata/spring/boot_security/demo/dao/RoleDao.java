package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;
import java.util.Optional;

public interface RoleDao {
    Role addRole(Role role);
    Set<Role> getAllRoles();
    Optional<Role> findByName(String name);
}