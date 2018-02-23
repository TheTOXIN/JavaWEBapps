package com.toxin.springSecurity.dao;

import com.toxin.springSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

}
