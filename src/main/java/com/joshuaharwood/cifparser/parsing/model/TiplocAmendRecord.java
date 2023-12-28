package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.TiplocAmendFields;

public record TiplocAmendRecord(String tiploc, byte capitalsIdentification, int nlc,
                                char nlcCheckCharacter, String tpsDescription, int stanox,
                                int poMcpCode, String threeAlphaCode, String nlcDescription,
                                String newTiploc, String spare) implements
    TiplocRecord<TiplocAmendFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_AMEND_RECORD;
  }

  @Override
  public String tiploc() {
    return null;
  }
}
