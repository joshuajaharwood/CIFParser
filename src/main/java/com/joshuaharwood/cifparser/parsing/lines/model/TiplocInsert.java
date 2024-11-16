package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;

public record TiplocInsert(String tiplocCode,
                           Byte capitalsIdentification,
                           String nlc,
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
