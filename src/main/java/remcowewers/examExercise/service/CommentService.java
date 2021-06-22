package remcowewers.examExercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.exceptions.CommentNotFoundException;
import remcowewers.examExercise.repository.CommentRepository;
import remcowewers.examExercise.domain.Comment;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    DemodropService demoService;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(long id) {

        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) throw new CommentNotFoundException(id);
        return comment;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(long id) {
        if (!commentRepository.existsById(id)) throw new CommentNotFoundException(id);
        Comment comment = commentRepository.findById(id).orElse(null);
        Demodrop demo = comment.getDemo();
        demo.setComment(null);
        commentRepository.deleteById(id);
    }
}