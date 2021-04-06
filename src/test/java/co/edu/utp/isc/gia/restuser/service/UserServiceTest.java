/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entitiy.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.exception.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;

/**
 *
 * @author dfch1
 */
public class UserServiceTest {

    private UserRepository userRepositoryTest;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        userRepositoryTest = Mockito.mock(UserRepository.class);
        modelMapper = new ModelMapper();

    }

    @Test
    public void testAllDataOk_ResultOk() {
        User resulted = new User(1L, "diego", "12345", "Diego", "d.calvera@utp");
        when(userRepositoryTest.save(any(User.class))).thenReturn(resulted);

        //input
        UserDto user = new UserDto(null, "DIEGO", "12345", "Diego", "d.calvera@utp");

        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Expected
        UserDto expResult = new UserDto(1L, "diego", "12345", "Diego", "d.calvera@utp");

        //Test
        UserDto result = instance.save(user);

        //Validaciones
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
    }
//

    @Test
    public void testParamNull_ResultException() {
        //input
        UserDto user = null;

        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Test 
        //Validaciones
        Assertions.assertThrows(BadRequestException.class, () -> {
            UserDto result = instance.save(user);
        });
    }

    @Test
    public void testListAll_ResultNullException() {
        //input
        //no data in db

        //target 
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Test
        //validations
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            List<UserDto> result = instance.listAll();
        });

    }

    @Test
    public void testFindOneAllDataOk_ResultOk() {
        User resulted = new User(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");
        when(userRepositoryTest.save(any(User.class))).thenReturn(resulted);

        //input
        Long id = 1L;

        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Expected
        UserDto expResult = new UserDto(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");

        //Test
        UserDto result = instance.findOne(id);

        //Validaciones
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
    }

    @Test
    public void testRemoveAllDataOk_ResultOk() {
        User resulted = new User(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");
        when(userRepositoryTest.save(any(User.class))).thenReturn(resulted);

        //input
        Long id = 1L;

        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Expected
        UserDto expResult = new UserDto(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");

        //Test
        UserDto result = instance.remove(id);

        //Validaciones
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
    }
    
     @Test
    public void testUpdateDataOk_ResultOk() {
        User resulted = new User(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");
        when(userRepositoryTest.save(any(User.class))).thenReturn(resulted);

        //input
        Long id = 1L;
        UserDto user = new UserDto(null, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");
        
        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Expected
        UserDto expResult = new UserDto(1L, "diego", "222", "Diego Calvera", "d.calvera@utp.edu.co");

        //Test
        UserDto result = instance.remove(id);

        //Validaciones
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
    }
//

    @Test
    public void testUpdateParamNull_ResultException() {
        //input
        Long id = null;
        UserDto user = null;

        //Target
        UserService instance = new UserService(userRepositoryTest, modelMapper);

        //Test 
        //Validaciones
        Assertions.assertThrows(UserNotFoundException.class, () -> {
           UserDto result = instance.update(id,user);
        });
    }
//   
}
