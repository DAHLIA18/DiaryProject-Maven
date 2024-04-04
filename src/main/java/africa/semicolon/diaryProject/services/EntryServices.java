package africa.semicolon.diaryProject.services;

import africa.semicolon.diaryProject.data.model.Entry;
import africa.semicolon.diaryProject.dtos.CreateEntryRequests;

import java.util.List;

public interface EntryServices {
    List<Entry> getEntriesFor(String username);

    Entry createNewEntryWith(String username, String title, String body);

    void deleteWith(String title);
    void addEntry(CreateEntryRequests createEntryRequest);

    long getNumberOfEntries();

}

