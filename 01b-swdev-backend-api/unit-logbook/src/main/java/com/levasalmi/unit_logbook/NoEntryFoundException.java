package com.levasalmi.unit_logbook;

import org.springframework.http.HttpStatus;

public class NoEntryFoundException extends BaseException {
  public NoEntryFoundException(Long id) {
    super(HttpStatus.NOT_FOUND, "No entry found with id: " + id);
  }
}
