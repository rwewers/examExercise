package remcowewers.examExercise.controller;

import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.service.UserService2;
import remcowewers.examExercise.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private UserService userService;
    private UserService2 userService2;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserService(UserService2 userService2) {
        this.userService2 = userService2;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAllUsers() {
        return userService.getAllUsers();
    }



    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() throws IOException {
        List<User> users = userService2.getAllUsers();
        return ResponseEntity.ok(users);



    }
}