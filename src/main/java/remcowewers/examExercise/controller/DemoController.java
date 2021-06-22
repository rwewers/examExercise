package remcowewers.examExercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.repository.UserRepository;
import remcowewers.examExercise.service.DemodropService;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/demos")
public class DemoController {

    @Autowired
    DemodropService demoService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllDemos() {
        return ResponseEntity.ok(demoService.getAllDemos());
    }

    @GetMapping("/{demoId}")
    public ResponseEntity<?> getDemo(@PathVariable("demoId") long demoId) throws IOException {
        Demodrop demo = demoService.getDemoById(demoId);
        return ResponseEntity.ok(demo);
    }

    @DeleteMapping("/{demoId}")
    public ResponseEntity<?> deleteDemo(@PathVariable("demoId") long demoId) throws IOException {
        demoService.deleteDemo(demoId);
        return ResponseEntity.ok("demo " + demoId + " deleted");
    }
}


