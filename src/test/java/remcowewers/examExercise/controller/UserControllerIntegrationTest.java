package remcowewers.examExercise.controller;

import remcowewers.examExercise.domain.User;
import  remcowewers.examExercise.service.UserService;
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
        user1.setEmail("remco@wewers.nl");
        user1.setFirstName("Remco");
        user1.setLastName("Wewers");

        User user2 = new User();
        user2.setUserId(1L);
        user2.setEmail("marcel@wewers.nl");
        user2.setFirstName("<Marcel>");
        user2.setLastName("Wewers");

        allUsers.add(user1);
        allUsers.add(user2);
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