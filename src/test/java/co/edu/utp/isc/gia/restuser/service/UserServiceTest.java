/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entitiy.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
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
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Long id = null;
//        UserService instance = null;
//        UserDto expResult = null;
//        UserDto result = instance.remove(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Long id = null;
//        UserDto user = null;
//        UserService instance = null;
//        UserDto expResult = null;
//        UserDto result = instance.update(id, user);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testListAll() {
//        System.out.println("listAll");
//        UserService instance = null;
//        List<UserDto> expResult = null;
//        List<UserDto> result = instance.listAll();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testFindOne() {
//        System.out.println("findOne");
//        Long id = null;
//        UserService instance = null;
//        UserDto expResult = null;
//        UserDto result = instance.findOne(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

}
