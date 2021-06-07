package controller;


import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    List<User> allUsers = new ArrayList<>();

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    // Arrange
    @BeforeEach
    public void setUpt() {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setEmail("elvis@gmail.com");
        user1.setFirstName("Elvis");
        user1.setLastName("Presley");

        User user2 = new User();
        user2.setUserId(1L);
        user2.setEmail("megamindy@gmail.com");
        user2.setFirstName("Mega");
        user2.setLastName("Mindy");

        allUsers.add(user1);
        allUsers.add(user2);
    }


    @Test
    public void testEndpointUsers() throws Exception {

        //Arrange
        User user = new User();
        user.setEmail("elvis@gmail.com");
        List<User> allUsers = Arrays.asList(user);

        given(userService.getAllUsers()).willReturn(allUsers);

        // Act & Assert
        mvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is(user.getEmail())));
    }

    @Test
    void endPointGettAllUsersIsSecured() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isUnauthorized())
                .andExpect(unauthenticated());
    }

    /*
    Database should run to invoke this test
     */
    @Test
    void endPointGetUserByUsernameIsStatusIsNotFound() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/users/check-up/test"))
                .andExpect(status().isNotFound())
                .andExpect(unauthenticated());
    }


}