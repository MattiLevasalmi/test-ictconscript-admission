package com.levasalmi.unit_logbook;

public class EntryDto {
  private int id;
  private String title;
  private String body;
  private String isoTime;
  private double lat;
  private double lon;

  public EntryDto(int id, String title, String body, String isoTime, double lat, double lon) {
    this(id, title, body, isoTime);
    this.lat = lat;
    this.lon = lon; 
  }

  public EntryDto(int id, String title, String body, String isoTime) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.isoTime = isoTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public String getIsoTime() {
    return isoTime;
  }

  public void setIsoTime(String isoTime) {
    this.isoTime = isoTime;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }
}
