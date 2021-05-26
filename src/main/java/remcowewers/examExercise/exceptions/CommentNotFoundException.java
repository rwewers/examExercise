package remcowewers.examExercise.exceptions;

public class CommentNotFoundException extends RuntimeException {


    public CommentNotFoundException(long id) {
        super("Cannot find review with id: " + id);
    }
}