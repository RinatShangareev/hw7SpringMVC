package ru.shangareevrr.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shangareevrr.common.entity.Role;
import ru.shangareevrr.common.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(Long id){
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()){
            return  role.get();
        }
        return null;
    }

    public Role createOrUpdate(Role Role){
        return roleRepository.save(Role);
    }

    public void delete(Long id){
        Optional<Role> role = roleRepository.findById(id);
        if (!role.isPresent()) {
            try {
                throw new Exception("Role with id = " + id + " not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        roleRepository.delete(role.get());
    }
}
