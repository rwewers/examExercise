package remcowewers.examExercise.service;

import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.payload.request.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public interface UserService {




    ResponseEntity<?> getAllUsers();
    ResponseEntity<?> updateUserById(String token,  @Valid UpdateUserRequest userRequest);
    ResponseEntity<?> findUserByToken(String token);

}
