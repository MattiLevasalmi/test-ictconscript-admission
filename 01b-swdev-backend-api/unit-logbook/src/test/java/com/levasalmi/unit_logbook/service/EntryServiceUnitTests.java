package com.levasalmi.unit_logbook.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.levasalmi.unit_logbook.entry.Entry;
import com.levasalmi.unit_logbook.entry.EntryCreationRequest;
import com.levasalmi.unit_logbook.entry.EntryDto;
import com.levasalmi.unit_logbook.exception.NoEntryFoundException;
import com.levasalmi.unit_logbook.repository.EntryRepository;

@ExtendWith(MockitoExtension.class)
class EntryServiceUnitTests {

  @InjectMocks
  private EntryService entryService;

  @Mock
  private EntryRepository entryRepository;

  @Test
  void contextLoads() {
  }

  @Test
  @DisplayName("Get all entries should return a list of entries")
  void getAllEntriesShouldReturnListOfEntries() {
    List<Entry> mockEntries = List.of(
        new Entry(1L, "Title 1", "Body 1", LocalDateTime.now(), 10.0, 20.0),
        new Entry(2L, "Title 2", "Body 2", LocalDateTime.now(), 30.0, 40.0));
    when(entryRepository.findAll()).thenReturn(mockEntries);

    List<EntryDto> entries = entryService.getAllEntries();

    assertEquals(2, entries.size());
    assertEntryDtoEquals(EntryDto.from(mockEntries.get(0)), entries.get(0));
    assertEntryDtoEquals(EntryDto.from(mockEntries.get(1)), entries.get(1));
  }

  @Test
  @DisplayName("Create entry should return the created entry")
  void createEntryShouldReturnEntry() {
    Entry mockEntry = new Entry(1L, "Title", "Body", LocalDateTime.now(), 10.0, 20.0);
    when(entryRepository.save(any(Entry.class))).thenReturn(mockEntry);

    EntryDto createdEntry = entryService.createEntry(
        new EntryCreationRequest("Title", "Body", 10.0, 20.0));

    assertEntryDtoEquals(EntryDto.from(mockEntry), createdEntry);
  }

  @Test
  @DisplayName("Get entry by id should return entry")
  void getEntryByIdShouldReturnEntry() {
    Entry mockEntry = new Entry(1L, "Title", "Body", LocalDateTime.now(), 10.0, 20.0);
    when(entryRepository.findById(1L)).thenReturn(Optional.of(mockEntry));

    EntryDto createdEntry = entryService.getEntryById(1L);

    assertEntryDtoEquals(EntryDto.from(mockEntry), createdEntry);
  }

  @Test
  @DisplayName("Get entry by id should throw NoEntryFoundException when entry not found")
  void getEntryByIdShouldThrowNoEntryFoundExceptionWhenEntryNotFound() {
    when(entryRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(NoEntryFoundException.class, () -> entryService.getEntryById(1L));
  }

  private void assertEntryDtoEquals(EntryDto expected, EntryDto actual) {
    assertAll(
        () -> assertEquals(expected.getId(), actual.getId(), "id"),
        () -> assertEquals(expected.getTitle(), actual.getTitle(), "title"),
        () -> assertEquals(expected.getBody(), actual.getBody(), "body"),
        () -> assertEquals(expected.getIsoTime(), actual.getIsoTime(), "isoTime"),
        () -> assertEquals(expected.getLat(), actual.getLat(), "lat"),
        () -> assertEquals(expected.getLon(), actual.getLon(), "lon"));
  }
}
