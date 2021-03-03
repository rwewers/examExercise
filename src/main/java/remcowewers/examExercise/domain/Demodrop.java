package remcowewers.examExercise.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "demo_drop")
public class Demodrop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;
    private String fileName;
    private String songTitle;
    private String artist;


    public Demodrop() {
    }

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getSongTitle() {
        return songTitle;
    }
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }


    //
//    @Override
//    public String toString() {
//        return "Demo{" +
//                "id=" + id +
//                ", user=" + user +
//                ", fileName='" + fileName + '\'' +
//                ", songTitle='" + songTitle + '\'' +
//                ", artist='" + artist + '\'' +
//
//                '}';
//    }
}
