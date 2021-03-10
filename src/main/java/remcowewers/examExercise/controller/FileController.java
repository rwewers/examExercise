package remcowewers.examExercise.controller;

import remcowewers.examExercise.domain.Demodrop;
import remcowewers.examExercise.domain.User;
import remcowewers.examExercise.service.FileService;
import remcowewers.examExercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import remcowewers.examExercise.service.UserService2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/api/fileUpload")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    UserService2 userService;

    @PostMapping
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") long userId,
                                             Demodrop demo) throws IOException {
        User user = userService.getUserById(userId);
        System.out.println(user);
        System.out.println(file);

        demo.setUser(user);
        System.out.println(demo);

        fileService.uploadFile(file, demo);
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

    //TODO ALWAYS REMEMBER, WHO HELPED YOU THE MOST. - E.T. THANKS

    @GetMapping("/{mp3}")
    public ResponseEntity<Object> downLoadFile(@PathVariable("mp3") String mp3) throws IOException {
        String fileName = fileService.uploadDirectory + mp3;
        System.out.println(fileName);
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("audio/mpeg")).body(resource);
        return responseEntity;

    }


    @PostMapping ("/user_id")
    public ResponseEntity<Object> uploadFile(@RequestParam("userId") long userId) throws IOException  {
        List<Demodrop> demo = userService.getDemosByUserId(userId);
        System.out.println(demo);
        return ResponseEntity.ok().body(userService.getDemosByUserId(userId));
    }
}
