package remcowewers.examExercise.payload.request;

import javax.persistence.Lob;

public class CommentRequest {

    private long commentId;
    @Lob
    private String message;
    private boolean viewed;
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

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
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
                ", viewed=" + viewed +
                ", demoId=" + demoId +
                '}';
    }
}