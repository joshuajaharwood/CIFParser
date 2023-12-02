package com.joshuaharwood.cifparser.records.model;

public enum RecordIdentity {
  HEADER_RECORD("HD", "Header Record"), TIPLOC_INSERT_RECORD("TI",
      "TIPLOC Insert Record"), TIPLOC_AMEND_RECORD("TA",
      "TIPLOC Amend Record"), TIPLOC_DELETE_RECORD("TD",
      "TIPLOC Delete Record"), ASSOCIATION_RECORD("AA", "Association Record"), BASIC_SCHEDULE("BS",
      "Basic Schedule"), BASIC_SCHEDULE_EXTRA_DETAILS("BX",
      "Basic Schedule Extra Details"), TRAIN_SPECIFIC_NOTE("TN",
      "Train-specific Note"), ORIGIN_LOCATION("LO", "Origin Location"), INTERMEDIATE_LOCATION("LI",
      "Intermediate Location"), CHANGE_EN_ROUTE("CR", "Change en Route"), TERMINATING_LOCATION("LT",
      "Terminating Location"), LOCATION_SPECIFIC_NOTE("LN",
      "Location-specific Note"), TRAILER_RECORD("ZZ", "Trailer Record (EOF)");

  private final String literal;
  private final String description;

  RecordIdentity(String literal, String description) {
    this.literal = literal;
    this.description = description;
  }

  public String getLiteral() {
    return literal;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "RecordIdentity{" + "literal='" + literal + '\'' + ", description='" + description + '\''
        + '}';
  }
}
