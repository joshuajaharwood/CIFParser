package com.joshuaharwood.records;

import java.util.Objects;

@SuppressWarnings("unused")
public abstract sealed class CIFRecord permits HeaderRecord, TiplocRecord {

  private final RecordIdentity recordIdentity;
  private final String spare;

  CIFRecord(RecordIdentity recordIdentity, String spare) {
    this.recordIdentity = recordIdentity;
    this.spare = spare;
  }

  public RecordIdentity getRecordIdentity() {
    return recordIdentity;
  }

  public String getSpare() {
    return spare;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CIFRecord cifRecord = (CIFRecord) o;
    return recordIdentity == cifRecord.recordIdentity && Objects.equals(spare, cifRecord.spare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordIdentity, spare);
  }

  @Override
  public String toString() {
    return "CIFRecord{" + "recordIdentity=" + recordIdentity + ", spare='" + spare + '\'' + '}';
  }
}
