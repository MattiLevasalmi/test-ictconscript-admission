package com.levasalmi.unit_logbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entries")
public class EntryController {

  @Autowired
  private final EntryService entryService;
  
  public EntryController(EntryService entryService) {
    this.entryService = entryService;
  }

  @GetMapping("")
  public List<EntryDto> getAllEntries() {
    return entryService.getAllEntries();
  }

  @PostMapping("")
  public EntryDto createEntry(@Valid @RequestBody EntryCreationRequest entry) {
    return entryService.createEntry(entry);
  }

  @GetMapping("/{id}")
  public EntryDto getEntryById(@PathVariable Long id) {
    return entryService.getEntryById(id);
  }
}
