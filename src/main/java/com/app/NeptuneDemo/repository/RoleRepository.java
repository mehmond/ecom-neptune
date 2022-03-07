package com.app.NeptuneDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
