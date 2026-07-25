package com.levasalmi.unit_logbook;

public class NoEntryFoundException extends RuntimeException {
  public NoEntryFoundException(Long id) {
    super("No entry found with id: " + id);
  }
}
