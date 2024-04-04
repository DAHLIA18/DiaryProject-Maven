package africa.semicolon.diaryProject.services;

import africa.semicolon.diaryProject.dtos.*;
import org.springframework.stereotype.Service;
@Service
public interface DiaryServices {
         String register(RegisterRequests registerRequest);
        String login(LoginRequest loginRequest);

        void createEntryWith(CreateEntryRequests createEntryRequest);

        String logout(LoginRequest loginRequest);

        DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest);

    long countUsers();
}
