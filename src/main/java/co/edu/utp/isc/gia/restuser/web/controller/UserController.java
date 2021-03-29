/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.exception.InvalidUserException;
import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dfch1
 */
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDto save(@RequestBody UserDto user) {
        if (user == null) {
            throw new BadRequestException("Parametro no valido");
        } else if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new InvalidUserException("username no puede ser vacio");
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidUserException("password no puede ser vacio");
        } else {
            return userService.save(user);
        }
    }

    @GetMapping()
    public List<UserDto> listAll() {
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserDto findOne(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @PutMapping("/{id}")
    public UserDto updateOne(@PathVariable("id") Long id, @RequestBody UserDto user) {
        if (user == null) {
            throw new BadRequestException("Parametro no valido");
        } else if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new InvalidUserException("username no puede ser vacio");
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidUserException("password no puede ser vacio");
        } else {
            return userService.update(id, user);
        }
    }

    @DeleteMapping("/{id}")
    public UserDto removeOne(@PathVariable("id") Long id) {
        return userService.remove(id);
    }
}
