package remcowewers.examExercise.service;

import remcowewers.examExercise.domain.Demodrop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import remcowewers.examExercise.exceptions.MaxFileSizeException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    DemodropService demodropService;


    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/";

    public void uploadFile(MultipartFile file, Demodrop demo) throws IOException {
        UUID uuid = UUID.randomUUID();
        demo.setFileName(uuid + ".mp3");
        file.transferTo(new File(uploadDirectory + demo.getFileName()));
        demodropService.saveDemo(demo);
    }

    public void deleteById(long demoId) {
        Demodrop demo = demodropService.getDemoById(demoId);
        String fileName = demo.getFileName();
        File audioFile = new File(uploadDirectory + fileName);
        if (audioFile.delete()) {
            System.out.println("Song is deleted: " + audioFile.getName());
        } else {
            System.out.println("Failed to delete the song..");
        }
    }
}