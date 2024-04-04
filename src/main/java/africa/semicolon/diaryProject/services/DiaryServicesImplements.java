package africa.semicolon.diaryProject.services;

import africa.semicolon.diaryProject.data.model.Diary;
import africa.semicolon.diaryProject.data.model.Entry;
import africa.semicolon.diaryProject.data.repositories.DiaryRepositories;
import africa.semicolon.diaryProject.data.repositories.EntryRepositories;
import africa.semicolon.diaryProject.dtos.*;
import africa.semicolon.diaryProject.exceptions.UsernameException;
import africa.semicolon.diaryProject.util.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServicesImplements implements DiaryServices{
    @Autowired
    private DiaryRepositories diaryRepositories;
    @Autowired

    private EntryRepositories entryRepositories;


    @Override
    public String register(RegisterRequests registerRequest) {
        if(diaryRepositories.findByUsername(registerRequest.getUsername()) != null)
            throw new UsernameException("username already exist");
        Diary diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diary.setFirstname(registerRequest.getFirstname());
        diary.setLastname(registerRequest.getLastname());
        diaryRepositories.save(diary);
        return "you registered successfully";
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositories.findByUsername(loginRequest.getUsername());
         foundDiary.setLocked(false);
          diaryRepositories.save(foundDiary);
          return "you have successfully logged in";
    }

    @Override
    public void createEntryWith(CreateEntryRequests createEntryRequest) {
        Entry entry = new Entry();
        entry.setBody(createEntryRequest.getBody());
        entry.setTitle(createEntryRequest.getTitle());
        entry.setDateCreated(createEntryRequest.getDateCreated());
        entryRepositories.save(entry);
    }
    @Override
    public String logout(LoginRequest loginRequest) {
        Diary foundDiary = diaryRepositories.findByUsername(loginRequest.getUsername());
        if(foundDiary != null && foundDiary.getPassword().
                equalsIgnoreCase(loginRequest.getPassword()))foundDiary.setLocked(true);
        diaryRepositories.save(foundDiary);
        return "you successfully logged out";
    }

    @Override
    public DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest) {
        Diary foundDiary = diaryRepositories.findByUsername(deleteDiaryRequest.getUsername());
        diaryRepositories.deleteDiariesBy(foundDiary);
        return Mappers.mapRequestToResponse(deleteDiaryRequest);
    }

    @Override
    public long countUsers() {
        return diaryRepositories.count();
    }
}
