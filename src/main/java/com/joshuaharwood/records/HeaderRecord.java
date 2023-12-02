package com.joshuaharwood.records;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@SuppressWarnings("unused")
final class HeaderRecord extends CIFRecord {

  private final String fileMainframeIdentity;
  private final LocalDate dateOfExtract;
  private final LocalTime timeOfExtract;
  private final String currentFileReference;
  private final String lastFileReference;
  private final UpdateIndicator updateIndicator;
  private final Character version;
  private final LocalDate userStartDate;
  private final LocalDate userEndDate;

  HeaderRecord(String fileMainframeIdentity,
      LocalDate dateOfExtract,
      LocalTime timeOfExtract,
      String currentFileReference,
      String lastFileReference,
      UpdateIndicator updateIndicator,
      Character version,
      LocalDate userStartDate,
      LocalDate userEndDate,
      String spare) {
    super(RecordIdentity.HEADER_RECORD, spare);
    validateVersion(version);
    this.fileMainframeIdentity = fileMainframeIdentity;
    this.dateOfExtract = dateOfExtract;
    this.timeOfExtract = timeOfExtract;
    this.currentFileReference = currentFileReference;
    this.lastFileReference = lastFileReference;
    this.updateIndicator = updateIndicator;
    this.version = version;
    this.userStartDate = userStartDate;
    this.userEndDate = userEndDate;
  }

  private static void validateVersion(Character version) {
    if (!Character.isUpperCase(version)) {
      throw new IllegalArgumentException(
          "A non-capital-alphanumeric Version property was passed as an argument. [Version: %s]".formatted(
              version));
    }
  }

  public String getFileMainframeIdentity() {
    return fileMainframeIdentity;
  }

  public LocalDate getDateOfExtract() {
    return dateOfExtract;
  }

  public LocalTime getTimeOfExtract() {
    return timeOfExtract;
  }

  public String getCurrentFileReference() {
    return currentFileReference;
  }

  public String getLastFileReference() {
    return lastFileReference;
  }

  public UpdateIndicator getUpdateIndicator() {
    return updateIndicator;
  }

  public Character getVersion() {
    return version;
  }

  public LocalDate getUserStartDate() {
    return userStartDate;
  }

  public LocalDate getUserEndDate() {
    return userEndDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    HeaderRecord that = (HeaderRecord) o;
    return Objects.equals(fileMainframeIdentity, that.fileMainframeIdentity) && Objects.equals(
        dateOfExtract,
        that.dateOfExtract) && Objects.equals(timeOfExtract, that.timeOfExtract) && Objects.equals(
        currentFileReference,
        that.currentFileReference) && Objects.equals(lastFileReference, that.lastFileReference)
        && updateIndicator == that.updateIndicator && Objects.equals(version, that.version)
        && Objects.equals(userStartDate, that.userStartDate) && Objects.equals(userEndDate,
        that.userEndDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(),
        fileMainframeIdentity,
        dateOfExtract,
        timeOfExtract,
        currentFileReference,
        lastFileReference,
        updateIndicator,
        version,
        userStartDate,
        userEndDate);
  }

  @Override
  public String toString() {
    return "HeaderRecord{" + "fileMainframeIdentity='" + fileMainframeIdentity + '\''
        + ", dateOfExtract=" + dateOfExtract + ", timeOfExtract=" + timeOfExtract
        + ", currentFileReference='" + currentFileReference + '\'' + ", lastFileReference='"
        + lastFileReference + '\'' + ", updateIndicator=" + updateIndicator + ", version=" + version
        + ", userStartDate=" + userStartDate + ", userEndDate=" + userEndDate + "} "
        + super.toString();
  }

  enum UpdateIndicator {
    UPDATE_EXTRACT('U', "Update Extract"), FULL_EXTRACT('F', "Full Extract");
    private final char literal;
    private final String description;

    UpdateIndicator(char literal, String description) {
      this.literal = literal;
      this.description = description;
    }

    @Override
    public String toString() {
      return "UpdateIndicator{" + "literal=" + literal + ", description='" + description + '\''
          + '}';
    }
  }
}
