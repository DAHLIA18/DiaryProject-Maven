package africa.semicolon.diaryProject.services;

import africa.semicolon.diaryProject.data.repositories.DiaryRepositories;
import africa.semicolon.diaryProject.dtos.LoginRequest;
import africa.semicolon.diaryProject.dtos.RegisterRequests;
import africa.semicolon.diaryProject.exceptions.UsernameException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class DiaryServicesImplementsTest {
    @Autowired
    private DiaryRepositories diaryRepositories;
    @Autowired
    private DiaryServices diaryServices;

    @Test
    public void testThatUserCanRegister_countIsOne() {
        diaryRepositories.deleteAll();
        RegisterRequests registerRequest = new RegisterRequests();
        registerRequest.setUsername("Faith");
        registerRequest.setPassword("Faith1");
        diaryServices.register(registerRequest);
        assertEquals(1, diaryRepositories.count());
    }

    @Test
    public void testThatUserCanRegisterTwoUsers() {
        RegisterRequests registerRequests = new RegisterRequests();
        registerRequests.setUsername("Faith");
        registerRequests.setPassword("Faith1");
        registerRequests.setUsername("Oge");
        registerRequests.setPassword("Oge2");
        diaryServices.register(registerRequests);
        assertEquals(2, diaryRepositories.count());
    }

    @Test
    public void testLoginToDiary() {
        RegisterRequests registerRequest = new RegisterRequests();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("BlessingB");
        registerRequest.setPassword("Blessing1");
        diaryServices.register(registerRequest);
        loginRequest.setUsername("Blessing");
        loginRequest.setPassword("Dahlia1");
        loginRequest.getUsername();
        loginRequest.getPassword();
        diaryServices.login(loginRequest);
//        assertEquals(1, diaryServices.countUsers());
    }

    @Test
    public void testLoginToDiary_incorrectPassword_throwException() {
        diaryRepositories.deleteAll();
        RegisterRequests registerRequest = new RegisterRequests();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("Dahlia");
        registerRequest.setPassword("Dahlia1");
        diaryServices.register(registerRequest);
        loginRequest.setUsername("Dahlia");
        loginRequest.setPassword("DAHLIA1");
        loginRequest.getUsername();
        loginRequest.getPassword();
        try {
            diaryServices.login(loginRequest);
        } catch (UsernameException message) {
            assertEquals(message.getMessage(), "Username is invalid");
        }
    }
}