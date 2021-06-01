package remcowewers.examExercise.service;


import org.springframework.stereotype.Service;


import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.exceptions.UserNotFoundException;
import remcowewers.examExercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        return user.get();
    }
    public List<Demodrop> getDemosByUserId(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        return user.get().getDemos();
    }
    public User getUserByUsername(String email) {
        Optional<User> user = userRepository.findByUsername(email);
        if (!user.isPresent()) {
            throw new UserNotFoundException(0);
        }
        return user.get();
    }
    public void updateUser(User user) {
        long userId = user.getUserId();
        Optional<User> existingUser = userRepository.findById(userId);
        if (!existingUser.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        User updatedUser = existingUser.get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFacebook(user.getFacebook());
        updatedUser.setInstagram(user.getInstagram());
        userRepository.save(updatedUser);
    }

}
