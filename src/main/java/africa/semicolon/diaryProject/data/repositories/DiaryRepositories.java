package africa.semicolon.diaryProject.data.repositories;

import africa.semicolon.diaryProject.data.model.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DiaryRepositories extends MongoRepository<Diary, String> {
   void deleteDiariesBy(Diary diary);
    Diary findByUsername(String username);

}
