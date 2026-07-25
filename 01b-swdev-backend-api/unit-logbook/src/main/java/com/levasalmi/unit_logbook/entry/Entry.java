package com.levasalmi.unit_logbook.entry;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entries")
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", length = 120, nullable = false)
  private String title;

  @Column(name = "body", nullable = false)
  private String body;

  @Column(name = "isoTime", nullable = false)
  private LocalDateTime isoTime;

  @Column(name = "lat", nullable = true)
  private Double lat;

  @Column(name = "lon", nullable = true)
  private Double lon;

  public Entry(Long id, String title, String body, LocalDateTime isoTime, Double lat, Double lon) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.isoTime = isoTime;
    this.lat = lat;
    this.lon = lon;
  }

  public Entry() {
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
}
