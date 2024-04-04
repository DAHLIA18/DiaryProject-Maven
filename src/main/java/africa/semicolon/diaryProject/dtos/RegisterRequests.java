package africa.semicolon.diaryProject.dtos;

import lombok.Data;

@Data
public class RegisterRequests {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
}
