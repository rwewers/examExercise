package remcowewers.examExercise.service;


import org.springframework.validation.annotation.Validated;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.exceptions.UserNotFoundException;
import remcowewers.examExercise.payload.response.MessageResponse;
import remcowewers.examExercise.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class DemodropService {


    private DemoRepository demoRepository;
    @Autowired
    public void setDemoRepository(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public void saveDemo(Demodrop demo) {
        demoRepository.save(demo);
        System.out.println(demo);
    }
//
//    public void getDemoById(long demoId) {
//        Optional<Demodrop> demodrop = demoRepository.findById(demoId);
//        if (demodrop.isPresent()) {
//            throw new UserNotFoundException(demoId);
//        }
//        return demodrop.get();
//    }
//

}
