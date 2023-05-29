package com.pet.pet;

import com.pet.pet.controller.UserController;
import com.pet.pet.controller.model.UserCreateRequest;
import com.pet.pet.model.User;
import com.pet.pet.service.PetService;
import com.pet.pet.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private PetService petService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("testUser");

        User user = new User();
        user.setName(userCreateRequest.getName());

        when(userService.registerUser(any(User.class))).thenReturn(user);

        ResponseEntity<String> response = userController.registerUser(userCreateRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User registered successfully", response.getBody());
    }


}
