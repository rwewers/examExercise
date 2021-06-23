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
        admin.setUsername("dondiablo");
        admin.setEmail("info@dondiablo.com");
        admin.setPassword("SuperAdmin123!");
        admin.setCountry("Netherlands");
        admin.setFacebook("https://nl-nl.facebook.com/OfficialDonDiablo");
        admin.setInstagram("https://www.instagram.com/dondiablo/?hl=nl");
        admin.setFirst_name("Don");
        admin.setLast_name("Diablo");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest user1 = new SignupRequest();
        user1.setUsername("wemsu");
        user1.setEmail("remco@wewers.nl");
        user1.setPassword("Novi21!");
        user1.setCountry("Netherlands");
        user1.setFacebook("https://nl-nl.facebook.com/remco.wewers");
        user1.setInstagram("https://www.instagram.com/remcowewers/?hl=nl");
        user1.setFirst_name("Remco");
        user1.setLast_name("Wewers");
        user1.setRole(rollen1);
        authorizationService.registerUser(user1);

        SignupRequest user2 = new SignupRequest();
        user2.setUsername("eekjenova");
        user2.setEmail("n.eeken@novi-hogescool.nl");
        user2.setPassword("varBanaan21!");
        user2.setCountry("Netherlands");
        user2.setFacebook("None");
        user2.setInstagram("None");
        user2.setFirst_name("Nova");
        user2.setLast_name("Eeken");
        user2.setRole(rollen1);
        authorizationService.registerUser(user2);




    }
}
