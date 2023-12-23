package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.fielddefinitions.TiplocInsertFields;
import java.util.List;

public record TiplocInsertRecord(String tiploc, byte capitalsIdentification, int nlc,
                                 char nlcCheckCharacter, String tpsDescription, int stanox,
                                 int poMcpCode, String threeAlphaCode, String nlcDescription,
                                 String spare) implements TiplocRecord<TiplocInsertFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.TIPLOC_INSERT_RECORD;
  }

  @Override
  public List<TiplocInsertFields> fields() {
    return List.of(TiplocInsertFields.values());
  }
}
