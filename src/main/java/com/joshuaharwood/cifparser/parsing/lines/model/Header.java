package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.UpdateIndicator;
import java.time.LocalDate;
import java.time.LocalTime;
import org.jspecify.annotations.NullUnmarked;
import org.jspecify.annotations.Nullable;

public record Header(String fileMainframeIdentity, LocalDate dateOfExtract, LocalTime timeOfExtract,
                     String currentFileReference, String lastFileReference,
                     UpdateIndicator updateIndicator, Character version, LocalDate userStartDate,
                     LocalDate userEndDate, @Nullable String spare) implements CifRecord {

  public Header {
    if (!Character.isUpperCase(version)) {
      throw new IllegalArgumentException(
        "A non-capital-alphanumeric Version property was passed as an argument. [Version: %s]".formatted(
          version));
    }
  }

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.HEADER_RECORD;
  }


  @NullUnmarked
  public static class Builder {
  
    private String fileMainframeIdentity;
    private LocalDate dateOfExtract;
    private LocalTime timeOfExtract;
    private String currentFileReference;
    private String lastFileReference;
    private UpdateIndicator updateIndicator;
    private Character version;
    private LocalDate userStartDate;
    private LocalDate userEndDate;
    private @Nullable String spare;
  
    public Builder setFileMainframeIdentity(String fileMainframeIdentity) {
      this.fileMainframeIdentity = fileMainframeIdentity;
      return this;
    }
  
    public Builder setDateOfExtract(LocalDate dateOfExtract) {
      this.dateOfExtract = dateOfExtract;
      return this;
    }
  
    public Builder setTimeOfExtract(LocalTime timeOfExtract) {
      this.timeOfExtract = timeOfExtract;
      return this;
    }
  
    public Builder setCurrentFileReference(String currentFileReference) {
      this.currentFileReference = currentFileReference;
      return this;
    }
  
    public Builder setLastFileReference(String lastFileReference) {
      this.lastFileReference = lastFileReference;
      return this;
    }
  
    public Builder setUpdateIndicator(UpdateIndicator updateIndicator) {
      this.updateIndicator = updateIndicator;
      return this;
    }
  
    public Builder setVersion(Character version) {
      this.version = version;
      return this;
    }
  
    public Builder setUserStartDate(LocalDate userStartDate) {
      this.userStartDate = userStartDate;
      return this;
    }
  
    public Builder setUserEndDate(LocalDate userEndDate) {
      this.userEndDate = userEndDate;
      return this;
    }
  
    public Builder setSpare(@Nullable String spare) {
      this.spare = spare;
      return this;
    }
  
    public Header createHeader() {
      return new Header(fileMainframeIdentity,
        dateOfExtract,
        timeOfExtract,
        currentFileReference,
        lastFileReference,
        updateIndicator,
        version,
        userStartDate,
        userEndDate,
        spare);
    }
  }
}