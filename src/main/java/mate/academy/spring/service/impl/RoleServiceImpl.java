package mate.academy.spring.service.impl;

import java.util.Optional;

import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }
}

