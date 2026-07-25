package com.levasalmi.unit_logbook.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levasalmi.unit_logbook.entry.Entry;
import com.levasalmi.unit_logbook.entry.EntryCreationRequest;
import com.levasalmi.unit_logbook.entry.EntryDto;
import com.levasalmi.unit_logbook.exception.NoEntryFoundException;
import com.levasalmi.unit_logbook.repository.EntryRepository;

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

  public EntryDto createEntry(EntryCreationRequest entryRequest) {
    Entry entry = new Entry();
    entry.setTitle(entryRequest.getTitle());
    entry.setBody(entryRequest.getBody());
    entry.setIsoTime(LocalDateTime.now());
    entry.setLat(entryRequest.getLat());
    entry.setLon(entryRequest.getLon());
    Entry savedEntry = entryRepository.save(entry);
    return EntryDto.from(savedEntry);
  }

  public EntryDto getEntryById(Long id) {
    return entryRepository.findById(id)
        .map(EntryDto::from)
        .orElseThrow(() -> new NoEntryFoundException(id));
  }
}
