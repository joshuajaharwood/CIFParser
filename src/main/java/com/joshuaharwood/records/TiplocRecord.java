package com.joshuaharwood.records;

import java.util.Objects;

@SuppressWarnings("unused")
public sealed abstract class TiplocRecord extends CIFRecord permits TiplocDeleteRecord,
    TiplocInsertRecord {

  private final String tiploc;

  TiplocRecord(RecordIdentity recordIdentity, String spare, String tiploc) {
    super(recordIdentity, spare);
    this.tiploc = tiploc;
  }

  public String getTiploc() {
    return tiploc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TiplocRecord that = (TiplocRecord) o;
    return Objects.equals(tiploc, that.tiploc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tiploc);
  }

  @Override
  public String toString() {
    return "TiplocRecord{" + "tiploc='" + tiploc + '\'' + "} " + super.toString();
  }
}
