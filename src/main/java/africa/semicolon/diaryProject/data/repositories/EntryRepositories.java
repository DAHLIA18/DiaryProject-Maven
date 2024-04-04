package africa.semicolon.diaryProject.data.repositories;

import africa.semicolon.diaryProject.data.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntryRepositories extends MongoRepository<Entry, String> {
    Optional<Entry> findEntryByAuthor(String author);
}
