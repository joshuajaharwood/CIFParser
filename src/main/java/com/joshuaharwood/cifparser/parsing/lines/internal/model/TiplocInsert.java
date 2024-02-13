package com.joshuaharwood.cifparser.parsing.lines.internal.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.model.enums.RecordIdentity;

public record TiplocInsert(String tiploc,
                           Byte capitalsIdentification,
                           Integer nlc,
                           Character nlcCheckCharacter,
                           String tpsDescription,
                           Integer stanox,
                           Integer poMcpCode,
                           String threeAlphaCode,
                           String nlcDescription,
                           String spare) implements TiplocRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }

}
