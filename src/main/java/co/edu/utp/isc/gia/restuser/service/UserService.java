/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entitiy.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exception.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfch1
 */
@Service
public class UserService {

    //private List<UserDto> users = new ArrayList<>();      //List para uso de datos locales
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto save(UserDto user) {
        User myUser = modelMapper.map(user, User.class);
        myUser = userRepository.save(myUser);
        UserDto resp = modelMapper.map(myUser, UserDto.class);
        return resp;
    }

    public UserDto remove(Long id) {
        if (userRepository.existsById(id)) {
            UserDto deleted = findOne(id);
            userRepository.deleteById(id);
            return deleted;
        }
        throw new UserNotFoundException("User Not Found");
    }

    public UserDto update(Long id, UserDto user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            UserDto updated = save(user);
            return updated;
        }
        throw new UserNotFoundException("User Not Found");
    }

    public List<UserDto> listAll() {
        List<UserDto> usersDto = null;
        List<User> users = (List<User>) userRepository.findAll();
        if (users != null && !users.isEmpty()) {
            usersDto = new ArrayList<>();
            for (User user : users) {
                usersDto.add(modelMapper.map(user, UserDto.class));
            }
        }
        return usersDto;
    }

    public UserDto findOne(Long id) {
        if (userRepository.existsById(id)) {
            return modelMapper.map(userRepository.findById(id).get(), UserDto.class);
        } else {
            throw new UserNotFoundException("Not Found");
        }
    }

}
