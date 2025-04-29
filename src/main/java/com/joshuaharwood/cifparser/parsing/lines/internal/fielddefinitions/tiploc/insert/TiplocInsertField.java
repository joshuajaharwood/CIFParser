package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TiplocInsertField<T> extends RowField<T> permits
  RecordIdentityField, TiplocCodeField, CapitalsField, NationalLocationCodeField,
  NlcCheckCharacterField, TpsDescriptionField, StanoxField, PoMcpCodeField,
  ThreeAlphaField, NlcDescriptionField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TiplocCodeField TIPLOC_CODE = new TiplocCodeField();
    public static final CapitalsField CAPITALS = new CapitalsField();
    public static final NationalLocationCodeField NATIONAL_LOCATION_CODE = new NationalLocationCodeField();
    public static final NlcCheckCharacterField NLC_CHECK_CHARACTER = new NlcCheckCharacterField();
    public static final TpsDescriptionField TPS_DESCRIPTION = new TpsDescriptionField();
    public static final StanoxField STANOX = new StanoxField();
    public static final PoMcpCodeField PO_MCP_CODE = new PoMcpCodeField();
    public static final ThreeAlphaField THREE_ALPHA_FIELD = new ThreeAlphaField();
    public static final NlcDescriptionField DESCRIPTION = new NlcDescriptionField();
    public static final SpareField SPARE = new SpareField();

    private Instances() {
    }
  }
}