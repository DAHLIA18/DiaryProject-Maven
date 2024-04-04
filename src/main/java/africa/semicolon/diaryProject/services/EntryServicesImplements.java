package africa.semicolon.diaryProject.services;

import africa.semicolon.diaryProject.data.model.Entry;
import africa.semicolon.diaryProject.data.repositories.EntryRepositories;
import africa.semicolon.diaryProject.dtos.CreateEntryRequests;
import africa.semicolon.diaryProject.exceptions.EntryNotFoundException;
import africa.semicolon.diaryProject.exceptions.InvalidDiaryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EntryServicesImplements implements EntryServices {
    @Autowired
    private EntryRepositories repositories;

    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = findByAuthor(username);
        if (entries.isEmpty()) throw new InvalidDiaryException("Diary not found");
        return entries;
    }

    @Override
    public Entry createNewEntryWith(String username, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setAuthor(username);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        return newEntry;
    }

    private  Entry findByTitle(String title){
        for(var entry :repositories.findAll())
            if(entry.getTitle().equalsIgnoreCase(title))return entry;
        return null;
    }


    private List<Entry> findByAuthor(String author){
        List<Entry> entries= new ArrayList<>();
        for(var entry: repositories.findAll())
            if(entry.getAuthor().equalsIgnoreCase(author))
                entries.add(entry);
        return entries;
    }

    @Override
    public void deleteWith(String title) {
        Entry entry = findByTitle(title);
        if (entry == null) throw new EntryNotFoundException("No entry found");
        repositories.delete(entry);
    }

    @Override
    public void addEntry(CreateEntryRequests createEntryRequest) {
        Entry entry = new Entry();
        entry.setAuthor(createEntryRequest.getAuthor());
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        repositories.save(entry);
    }

    @Override
    public long getNumberOfEntries() {
        return repositories.count();
    }
}
