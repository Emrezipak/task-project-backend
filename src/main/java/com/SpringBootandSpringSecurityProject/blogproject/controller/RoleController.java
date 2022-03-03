package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import com.SpringBootandSpringSecurityProject.blogproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role){
        return this.roleService.addRole(role);
    }

    @GetMapping("/getAllRole")
    public List<Role> getAllRole(){
        return this.roleService.getAllRole();
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable long id){
        this.roleService.deleteRole(id);
    }
}
