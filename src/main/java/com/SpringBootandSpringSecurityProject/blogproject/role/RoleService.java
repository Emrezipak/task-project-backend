package com.SpringBootandSpringSecurityProject.blogproject.role;

import com.SpringBootandSpringSecurityProject.blogproject.payload.response.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
       return this.roleRepository.save(role);
    }

    public List<Role> getAllRole() {
        return this.roleRepository.findAll();
    }

    public Role getRoleByRoleName(String name){
        Optional<Role> role=this.roleRepository.getByRoleName(name);
        if(role.isPresent()){
            return role.get();
        }
        return role.orElse(null);
    }

    public void deleteRole(long id) {
        Optional<Role> role=this.roleRepository.findById(id);
        if(role.isPresent()){
            this.roleRepository.deleteById(id);
        }
        throw new NullPointerException("Role bulunamadı");
    }
}
