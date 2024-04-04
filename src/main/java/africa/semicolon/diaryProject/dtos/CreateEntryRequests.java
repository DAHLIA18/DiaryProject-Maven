package africa.semicolon.diaryProject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class CreateEntryRequests {
    @Id
    private String id;
    private String title;
    private String body;
    private LocalDate dateCreated;
    private String author;
}
