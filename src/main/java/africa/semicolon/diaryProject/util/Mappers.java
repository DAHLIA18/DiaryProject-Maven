package africa.semicolon.diaryProject.util;

import africa.semicolon.diaryProject.dtos.DeleteDiaryRequest;
import africa.semicolon.diaryProject.dtos.DeleteDiaryResponse;

public class Mappers {


   public static DeleteDiaryResponse mapRequestToResponse(DeleteDiaryRequest deleteDiaryRequest){
       DeleteDiaryResponse deleteDiaryResponse = new DeleteDiaryResponse();
           deleteDiaryResponse.setUsername(deleteDiaryRequest.getUsername());
           return deleteDiaryResponse;
   }
}
