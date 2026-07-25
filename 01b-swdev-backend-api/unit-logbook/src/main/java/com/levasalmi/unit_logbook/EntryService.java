package com.levasalmi.unit_logbook;

import java.util.List;

public class EntryService {
  
  public EntryService() {}

  public List<EntryDto> getAllEntries() {
    return List.of(
      new EntryDto(1, "Test title 1", "Test body 1", "2024-06-01T12:00:00Z", 60.192059, 24.945831),
      new EntryDto(2, "Test title 2", "Test body 2", "2024-06-02T12:00:00Z", 60.169856, 24.938379),
      new EntryDto(3, "Test title 3", "Test body 3", "2024-06-03T12:00:00Z", 60.205490, 24.655899)
    );
  }

  public EntryDto getEntryById(int id) {
    return new EntryDto(id, "Test title", "Test body", "2024-06-01T12:00:00Z", 60.192059, 24.945831);
  }
}
