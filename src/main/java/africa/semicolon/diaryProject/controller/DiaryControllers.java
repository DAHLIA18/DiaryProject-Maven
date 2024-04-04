package africa.semicolon.diaryProject.controller;

import africa.semicolon.diaryProject.dtos.DeleteDiaryRequest;
import africa.semicolon.diaryProject.exceptions.DiaryException;
import africa.semicolon.diaryProject.dtos.LoginRequest;
import africa.semicolon.diaryProject.dtos.RegisterRequests;
import africa.semicolon.diaryProject.services.DiaryServicesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/diary")
public class DiaryControllers {
    @Autowired
    private DiaryServicesImplements diaryServicesImplements;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequests registerRequests) {
        try {
            diaryServicesImplements.register(registerRequests);
            return "successfully registered";
        } catch (DiaryException diaryException) {
            return diaryException.getMessage();
        }
    }


    @PostMapping("/log-in")
    public String logIn(@RequestBody LoginRequest loginRequest) {
        try {
            return diaryServicesImplements.login(loginRequest);

        } catch (DiaryException diaryException) {
            return diaryException.getMessage();
        }

    }

    @PostMapping("/logged-out")
    public String loggedOut(@RequestBody LoginRequest loginRequest) {
        try {
            return diaryServicesImplements.logout(loginRequest);
        } catch (DiaryException diaryException) {
            return diaryException.getMessage();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteDiaryRequest deleteDiaryRequest) {
        try {
            return new ResponseEntity<>(diaryServicesImplements.deleteDiary(deleteDiaryRequest), HttpStatus.CREATED);
        } catch (DiaryException diaryException) {
            return new ResponseEntity<>(diaryException.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}