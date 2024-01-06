package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;

public record TiplocAmend(String tiploc,
                          Byte capitalsIdentification,
                          Integer nlc,
                          Character nlcCheckCharacter,
                          String tpsDescription,
                          Integer stanox,
                          Integer poMcpCode,
                          String threeAlphaCode,
                          String nlcDescription,
                          String newTiploc,
                          String spare) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_AMEND_RECORD;
  }
}
