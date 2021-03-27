/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;


import co.edu.utp.isc.gia.restuser.config.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfch1
 */
@Service
public class UserService {

    private List<UserDto> users = new ArrayList<>();

    public UserDto save(UserDto user) {
        if (users.isEmpty()) {
            user.setId(users.size() + 1L);
            user.setUsername(user.getUsername().toLowerCase());
            users.add(user);
        } else {
            user.setId(users.get(users.size() - 1).getId() + 1);
            user.setUsername(user.getUsername().toLowerCase());
            users.add(user);
        }
        return user;
    }

    public UserDto update(Long id, UserDto user) {
        for (UserDto userdto : users) {
            if (userdto.getId().equals(id)) {
                user.setId(id);
                users.set(users.indexOf(userdto), user);
                return user;
            }
        }
        throw null;
    }

    public UserDto remove(Long id) {
        for (UserDto userdto : users) {
            if (userdto.getId().equals(id)) {
                return users.remove(users.indexOf(userdto));
            }
        }
        throw null;
    }

    public List<UserDto> listAll() {
        return users;
    }

    public UserDto findOne(Long id) {
        for (UserDto userdto : users) {
            if (userdto.getId().equals(id)) {
                return userdto;
            }
        }
        throw new UserNotFoundException("Not Found");
    }
}
