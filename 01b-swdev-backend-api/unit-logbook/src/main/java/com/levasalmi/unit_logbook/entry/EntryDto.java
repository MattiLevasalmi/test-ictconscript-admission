package com.levasalmi.unit_logbook.entry;

import java.time.LocalDateTime;

public class EntryDto {
  private Long id;
  private String title;
  private String body;
  private LocalDateTime isoTime;
  private Double lat;
  private Double lon;

  public EntryDto(Long id, String title, String body, LocalDateTime isoTime, Double lat, Double lon) {
    this(id, title, body, isoTime);
    this.lat = lat;
    this.lon = lon;
  }

  public EntryDto(Long id, String title, String body, LocalDateTime isoTime) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.isoTime = isoTime;
  }

  public EntryDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public LocalDateTime getIsoTime() {
    return isoTime;
  }

  public void setIsoTime(LocalDateTime isoTime) {
    this.isoTime = isoTime;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public static EntryDto from(Entry entry) {
    return new EntryDto(
        entry.getId(),
        entry.getTitle(),
        entry.getBody(),
        entry.getIsoTime(),
        entry.getLat(),
        entry.getLon());
  }
}
