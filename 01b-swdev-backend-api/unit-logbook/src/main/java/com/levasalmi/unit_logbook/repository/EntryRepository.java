package com.levasalmi.unit_logbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levasalmi.unit_logbook.entry.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}