package remcowewers.examExercise.controller;

import remcowewers.examExercise.payload.request.LoginRequest;
import remcowewers.examExercise.payload.request.SignupRequest;
import remcowewers.examExercise.payload.response.JwtResponse;
import remcowewers.examExercise.payload.response.MessageResponse;
import remcowewers.examExercise.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {

        return authorizationService.registerUser(signUpRequest);
    }
}
