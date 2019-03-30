package com.aymericbocquet.rss.data.dao;

import com.aymericbocquet.rss.data.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByAuthority(String authority);
}
