package com.levasalmi.unit_logbook;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class EntryController {
  private final EntryService entryService;
  
  public EntryController(EntryService entryService) {
    this.entryService = entryService;
  }

  @GetMapping("")
  public List<EntryDto> getAllEntries() {
    return entryService.getAllEntries();
  }

  @GetMapping("/{id}")
  public EntryDto getEntryById(@PathVariable int id) {
    return entryService.getEntryById(id);
  }
}
