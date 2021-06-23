package remcowewers.examExercise.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Remco");
        user.setLastName("Wewers");
    }

    @Test
    void getFullNameTest() {

        String expectedFullName = "Remco Wewers";
        String actualFullName = this.user.getFullName();
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void emailToLowercaseTest() {

        user.setEmail("Remco@WeWers.nl");
        String expectedEmail = "remco@wewers.nl";
        String actualEmail = user.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void emailTrimAllWhiteSpacesTest() {

        user.setEmail(" remc o @we wers.nl ");
        String expectedEmail = "remco@wewers.nl";
        String actualEmail = user.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void addDemoMakesListSizeEqualTo1() {
        Demodrop demo = new Demodrop();
        demo.setSongTitle("Fly Me To The Moon");
        demo.setArtist("Frank Sinatra");
        int expectedListSize = 1;
        user.addDemo(demo);
        assertEquals(expectedListSize, user.getDemos().size());
    }

}