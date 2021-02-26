package remcowewers.examExercise.exceptions;

public class UserNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(long userId) {
        super("Cannot find user " + userId);
    }
}
