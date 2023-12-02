package com.joshuaharwood.records;

import java.util.Objects;

@SuppressWarnings("unused")
public final class TiplocInsertRecord extends TiplocRecord {

  private final byte capitalsIdentification;
  private final int nlc;
  private final char nlcCheckCharacter;
  private final String tpsDescription;
  private final int stanox;
  private final int poMcpCode;
  private final String threeAlphaCode;
  private final String nlcDescription;

  TiplocInsertRecord(String spare,
      String tiploc,
      byte capitalsIdentification,
      int nlc,
      char nlcCheckCharacter,
      String tpsDescription,
      int stanox,
      int poMcpCode,
      String threeAlphaCode,
      String nlcDescription) {
    super(RecordIdentity.TIPLOC_INSERT_RECORD, spare, tiploc);
    this.capitalsIdentification = capitalsIdentification;
    this.nlc = nlc;
    this.nlcCheckCharacter = nlcCheckCharacter;
    this.tpsDescription = tpsDescription;
    this.stanox = stanox;
    this.poMcpCode = poMcpCode;
    this.threeAlphaCode = threeAlphaCode;
    this.nlcDescription = nlcDescription;
  }

  public char getNlcCheckCharacter() {
    return nlcCheckCharacter;
  }

  public String getTpsDescription() {
    return tpsDescription;
  }

  public int getStanox() {
    return stanox;
  }

  public int getPoMcpCode() {
    return poMcpCode;
  }

  public String getThreeAlphaCode() {
    return threeAlphaCode;
  }

  public String getNlcDescription() {
    return nlcDescription;
  }

  public byte getCapitalsIdentification() {
    return capitalsIdentification;
  }

  public int getNlc() {
    return nlc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TiplocInsertRecord that = (TiplocInsertRecord) o;
    return capitalsIdentification == that.capitalsIdentification && nlc == that.nlc
        && nlcCheckCharacter == that.nlcCheckCharacter && stanox == that.stanox
        && poMcpCode == that.poMcpCode && Objects.equals(tpsDescription, that.tpsDescription)
        && Objects.equals(threeAlphaCode, that.threeAlphaCode) && Objects.equals(nlcDescription,
        that.nlcDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capitalsIdentification,
        nlc,
        nlcCheckCharacter,
        tpsDescription,
        stanox,
        poMcpCode,
        threeAlphaCode,
        nlcDescription);
  }

  @Override
  public String toString() {
    return "TiplocInsertRecord{" + "capitalsIdentification=" + capitalsIdentification + ", nlc="
        + nlc + ", nlcCheckCharacter=" + nlcCheckCharacter + ", tpsDescription='" + tpsDescription
        + '\'' + ", stanox=" + stanox + ", poMcpCode=" + poMcpCode + ", threeAlphaCode='"
        + threeAlphaCode + '\'' + ", nlcDescription='" + nlcDescription + '\'' + "} "
        + super.toString();
  }
}
