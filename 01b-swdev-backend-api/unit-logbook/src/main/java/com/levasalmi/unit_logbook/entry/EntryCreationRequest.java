package com.levasalmi.unit_logbook.entry;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EntryCreationRequest {

  @NotBlank(message = "Title cannot be blank")
  @Size(max = 120, message = "Title cannot exceed 120 characters")
  String title;

  @NotBlank(message = "Body cannot be blank")
  String body;

  @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90.0 and 90.0")
  @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90.0 and 90.0")
  Double lat;

  @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180.0 and 180.0")
  @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180.0 and 180.0")
  Double lon;

  public EntryCreationRequest(String title, String body, Double lat, Double lon) {
    this.title = title;
    this.body = body;
    this.lat = lat;
    this.lon = lon;
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
