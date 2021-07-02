package remcowewers.examExercise.payload.request;

import javax.persistence.Lob;

public class CommentRequest {

    private long commentId;
    @Lob
    private String message;
    private long demoId;

    public long getCommentId() {
        return commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDemoId() {
        return demoId;
    }

    public void setDemoId(long demoId) {
        this.demoId = demoId;
    }

    @Override
    public String toString() {
        return "CommentRequest{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", demoId=" + demoId +
                '}';
    }
}