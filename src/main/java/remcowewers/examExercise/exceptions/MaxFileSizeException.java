package remcowewers.examExercise.exceptions;

public class MaxFileSizeException extends RuntimeException {

    public MaxFileSizeException() {
        super("Maximum upload size exceeded");
    }
}


