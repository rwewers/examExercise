package remcowewers.examExercise.repository;

import remcowewers.examExercise.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}