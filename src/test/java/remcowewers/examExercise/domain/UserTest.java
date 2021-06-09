package remcowewers.examExercise.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    // Arrange
    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Remco");
        user.setLastName("Wewers");
    }

    @Test
    void getFullNameTest() {

        // Arrange
        String expectedFullName = "Remco Wewers";

        // Act
        String actualFullName = this.user.getFullName();

        // Assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void emailToLowercaseTest() {

        // Arrange
        user.setEmail("Remco@WeWers.nl");
        String expectedEmail = "remco@wewers.nl";

        // Act
        String actualEmail = user.getEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void emailTrimAllWhiteSpacesTest() {

        // Arrange
        user.setEmail(" remc o @we wers.nl ");
        String expectedEmail = "remco@wewers.nl";

        // Act
        String actualEmail = user.getEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void addDemoMakesListSizeEqualTo1() {

        // Arrange
        Demodrop demo = new Demodrop();
        demo.setSongTitle("Fly Me To The Moon");
        demo.setArtist("Frank Sinatra");

        int expectedListSize = 1;

        // Act
        user.addDemo(demo);

        // Assert
        assertEquals(expectedListSize, user.getDemos().size());
    }

}