package ru.shangareevrr.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shangareevrr.common.entity.Role;
import java.util.List;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>  {

    List<Role> findAll();
}
