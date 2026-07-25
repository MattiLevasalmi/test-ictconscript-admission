package com.levasalmi.unit_logbook;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

  @Autowired
  private final EntryRepository entryRepository;

  public EntryService(EntryRepository entryRepository) {
    this.entryRepository = entryRepository;
  }

  public List<EntryDto> getAllEntries() {
    return entryRepository.findAll().stream()
      .map(EntryDto::from)
      .toList();
  }

  public EntryDto createEntry(String title, String body, Double lat, Double lon) {
    Entry entry = new Entry();
    entry.setTitle(title);
    entry.setBody(body);
    entry.setIsoTime(LocalDateTime.now());
    entry.setLat(lat);
    entry.setLon(lon);
    Entry savedEntry = entryRepository.save(entry);
    return EntryDto.from(savedEntry);
  }

  public EntryDto getEntryById(Long id) {
    return entryRepository.findById(id)
        .map(EntryDto::from)
        .orElseThrow(() -> new NoEntryFoundException(id));
  }
}
