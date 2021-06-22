package remcowewers.examExercise.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    @Column(columnDefinition = "TEXT")
    String message;
    boolean viewed;

    @OneToOne
    @JsonIgnore
    private Demodrop demo;

    public Comment() {
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
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

    public Demodrop getDemo() {
        return demo;
    }

    public void setDemo(Demodrop demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", viewed=" + viewed +
                ", demo=" + demo +
                '}';
    }
}
