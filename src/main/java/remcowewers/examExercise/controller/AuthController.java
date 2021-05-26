package remcowewers.examExercise.controller;


import remcowewers.examExercise.payload.request.LoginRequest;
import remcowewers.examExercise.payload.request.SignupRequest;
import remcowewers.examExercise.payload.response.JwtResponse;
import remcowewers.examExercise.payload.response.MessageResponse;
import remcowewers.examExercise.service.AuthorizationService;
import remcowewers.examExercise.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Uitleg over CrossOrigin en CORS:
 * https://medium.com/@baphemot/understanding-cors-18ad6b478e2b
 *
 * Gebruik in Spring-boot (op controller en globally)
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 *
 * Zoals je hieronder ziet, kun je ook op klasse-niveau een adres configureren. Iaw alle methodes hieronder, hebben
 * /api/auth voor de link staan.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @Autowired
    AuthorizationService authorizationService;


    @Autowired
    EmailService emailService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        emailService.signUpEmail();
        return authorizationService.registerUser(signUpRequest);
    }





}
