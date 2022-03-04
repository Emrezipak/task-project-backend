package com.SpringBootandSpringSecurityProject.blogproject.service;

import com.SpringBootandSpringSecurityProject.blogproject.apierror.NotFoundRole;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import com.SpringBootandSpringSecurityProject.blogproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Set<Role> controlByRoleName(Set<String> roles) {
        Set<Role> roleList = new HashSet<>();
        for (String role : roles) {
            Role getRole = getRoleByRoleName(role);
            if (getRole == null) {
                throw new NotFoundRole("not found role");
            }
            roleList.add(getRole);
        }

        return roleList;
    }

}
