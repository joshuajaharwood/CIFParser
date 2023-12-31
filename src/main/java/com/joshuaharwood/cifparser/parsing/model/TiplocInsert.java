package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TiplocInsertFields;

public record TiplocInsert(String tiploc, byte capitalsIdentification, int nlc,
                           char nlcCheckCharacter, String tpsDescription, int stanox,
                           int poMcpCode, String threeAlphaCode, String nlcDescription,
                           String spare) implements TiplocRecord<TiplocInsertFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }

}
