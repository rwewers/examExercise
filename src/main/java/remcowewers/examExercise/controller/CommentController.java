package remcowewers.examExercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import remcowewers.examExercise.payload.request.CommentRequest;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.service.CommentService;
import remcowewers.examExercise.service.DemodropService;
import remcowewers.examExercise.domain.Comment;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    private DemodropService demoService;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllComments() throws IOException {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<?> getCommentById(@PathVariable("commentId") long commentId) throws IOException {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    @PostMapping
    public ResponseEntity<?> addNewComment(@RequestBody CommentRequest commentRequest) throws IOException {
        Demodrop demo = demoService.getDemoById(commentRequest.getDemoId());
        Comment comment = new Comment();
        comment.setMessage(commentRequest.getMessage());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("commentId") long commentId,@RequestBody CommentRequest commentRequest) {
        Demodrop demo = demoService.getDemoById(commentRequest.getDemoId());
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setMessage(commentRequest.getMessage());
        comment.setViewed(commentRequest.isViewed());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable("id") long id) throws IOException {
        commentService.deleteComment(id);
        return ResponseEntity.ok("comment " + id + " deleted");
    }

}
