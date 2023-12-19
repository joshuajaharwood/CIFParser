package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;

public record TiplocInsertRecord(String spare, String tiploc, byte capitalsIdentification, int nlc,
                                 char nlcCheckCharacter, String tpsDescription, int stanox,
                                 int poMcpCode, String threeAlphaCode,
                                 String nlcDescription) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }
}
