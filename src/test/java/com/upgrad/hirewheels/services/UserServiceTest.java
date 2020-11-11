package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UsersDao usersDao;

    @Mock
    private RoleDao roleDao;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setupMockito() {
        Mockito.when(usersDao.save(new Users("Save", "Test", "kaps#12","kaps@mail.com", "9909999999", 556, roleDao.findById(1).get())))
                .thenReturn(new Users("Save", "Test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get()));

        Mockito.when(usersDao.findById(1)).thenReturn(Optional.of(new Users("Save", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get())));
        Mockito.when(usersDao.save(new Users("Update", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get())))
                .thenReturn(new Users("Update", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get()));

        Mockito.when(usersDao.save(new Users("Get", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get())))
                .thenReturn(new Users("Get", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get()));
        Mockito.when(usersDao.findByFirstNameIgnoreCase("Get")).thenReturn((List<Users>)new Users("Get", "test", "kaps#12", "kaps@mail.com", "9909999999", 556, roleDao.findById(1).get()));

        Mockito.when(roleDao.findById(1)).thenReturn(Optional.of(new Role(1, "Admin")));

    }

    @Test
    public void testCreateUser() {

        Users users = new Users();
        users.setFirstName("Save");
        users.setLastName("Test");
        users.setPassword("kaps#120");
        users.setEmail("kaps@mail.com");
        users.setWalletMoney(556);
        users.setRole(roleDao.findById(1).get());
        usersDao.save(users);

    }

    @Test
    public void testGetUsers() throws UserNotRegisteredException {

        Users users = new Users();
        users.setFirstName("Save");
        users.setLastName("Test");
        users.setPassword("kaps#120");
        users.setEmail("kaps@mail.com");
        users.setWalletMoney(556);
        users.setRole(roleDao.findById(1).get());
        usersDao.save(users);

        Users savedUser = (Users) usersDao.findByFirstNameIgnoreCase("Get");
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("Get", savedUser.getFirstName());

    }
}
