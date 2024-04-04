package africa.semicolon.diaryProject.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document("Entry")
public class Entry {
    private String title;
    private String body;
    @Id
    private String id;
    private String author;
    private LocalDate dateCreated = LocalDate.now();
}

