package africa.semicolon.diaryProject.dtos;

import lombok.Data;

@Data
public class DeleteDiaryRequest {
    private String Username;
    private String password;
    private String id;
}
