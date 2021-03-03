package remcowewers.examExercise.service;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import  remcowewers.examExercise.domain.Demodrop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.repository.DemoRepository;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    DemodropService demodropService;


    public static String uploadDirectory = System.getProperty("user.dir") + "/examExercise/uploads/";
    public void uploadFile(MultipartFile file, Demodrop demo) throws IOException {
        UUID uuid = UUID.randomUUID();
        demo.setFileName(uuid + ".mp3");
        file.transferTo(new File(uploadDirectory + demo.getFileName()));
        demodropService.saveDemo(demo);
    }

//    public void deleteById(long demoId) {
//        Demodrop demo = demodropService.getDemoById(demoId);
//        String fileName = demo.getFileName();
//        File audioFile = new File(uploadDirectory + fileName);
//        if (audioFile.delete()) {
//            System.out.println("Deleted the file: " + audioFile.getName());
//        } else {
//            System.out.println("Failed to delete the file.");
//        }
//    }
}