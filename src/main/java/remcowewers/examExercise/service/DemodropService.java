package remcowewers.examExercise.service;


import org.springframework.validation.annotation.Validated;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.exceptions.DemoNotFoundException;
import remcowewers.examExercise.exceptions.UserNotFoundException;
import remcowewers.examExercise.payload.response.MessageResponse;
import remcowewers.examExercise.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DemodropService {

    @Autowired
    FileService fileService;

    private DemoRepository demoRepository;
    @Autowired
    public void setDemoRepository(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public void saveDemo(Demodrop demo) {
        demoRepository.save(demo);
        System.out.println(demo);
    }

    public List<Demodrop> getAllDemos() {
        List<Demodrop> demos = demoRepository.findAllByOrderByUser();
        for (Demodrop demo:demos) {
            demo.getUser().setDemos(null);
        }
        return demos;
    }

    public Demodrop getDemoById(long demoId) {
        Optional<Demodrop> demo = demoRepository.findById(demoId);
        if (!demo.isPresent()) {
            throw new DemoNotFoundException(demoId);
        }
        return demo.get();
    }

    public void deleteDemo(long demoId) {
        if (!demoRepository.existsById(demoId)) throw new DemoNotFoundException(demoId);
        fileService.deleteById(demoId);
        demoRepository.deleteById(demoId);
    }

}
