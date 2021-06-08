package remcowewers.examExercise;


import remcowewers.examExercise.payload.request.SignupRequest;
import remcowewers.examExercise.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseFiller implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> rollen = new HashSet<>();
        rollen.add("admin");

        Set<String> rollen1 = new HashSet<>();
        rollen1.add("USER");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("nick");
        admin.setEmail("nick@admin.nl");
        admin.setPassword("nicknick");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest user1 = new SignupRequest();
        user1.setUsername("wemsu");
        user1.setEmail("remco@wewers.nl");
        user1.setPassword("Speed1994!");
        user1.setCountry("Netherlands");
        user1.setFacebook("None");
        user1.setInstagram("None");
        user1.setFirst_name("Remco");
        user1.setLast_name("Wewers");
        user1.setRole(rollen1);
        authorizationService.registerUser(user1);

        SignupRequest user2 = new SignupRequest();
        user2.setUsername("dansu");
        user2.setEmail("danivanrijt13@gmail.com");
        user2.setPassword("Speed1994!");
        user2.setCountry("Netherlands");
        user2.setFacebook("None");
        user2.setInstagram("None");
        user2.setFirst_name("Dani");
        user2.setLast_name("Van Rijt");
        user2.setRole(rollen1);
        authorizationService.registerUser(user2);




    }
}
