package africa.semicolon.diaryProject.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Diary")
public class Diary {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private boolean isLocked = true;
}

