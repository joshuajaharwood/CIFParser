package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.amend;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TiplocAmendField<T> extends RowField<T> permits RecordIdentityField,
  TiplocCodeField, CapitalsIdentificationField, NlcField, NlcCheckCharacterField,
  TpsDescriptionField, StanoxField, PoMcpCodeField, ThreeAlphaCodeField, NlcDescriptionField,
  NewTiplocField, SpareField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY_FIELD = new RecordIdentityField();
    public static final TiplocCodeField TIPLOC_CODE_FIELD = new TiplocCodeField();
    public static final CapitalsIdentificationField CAPITALS_IDENTIFICATION_FIELD = new CapitalsIdentificationField();
    public static final NlcField NLC_FIELD = new NlcField();
    public static final NlcCheckCharacterField NLC_CHECK_CHARACTER_FIELD = new NlcCheckCharacterField();
    public static final TpsDescriptionField TPS_DESCRIPTION_FIELD = new TpsDescriptionField();
    public static final StanoxField STANOX_FIELD = new StanoxField();
    public static final PoMcpCodeField PO_MCP_CODE_FIELD = new PoMcpCodeField();
    public static final ThreeAlphaCodeField THREE_ALPHA_CODE_FIELD = new ThreeAlphaCodeField();
    public static final NlcDescriptionField NLC_DESCRIPTION_FIELD = new NlcDescriptionField();
    public static final NewTiplocField NEW_TIPLOC_FIELD = new NewTiplocField();
    public static final SpareField SPARE_FIELD = new SpareField();

    private Instances() {
    }
  }
}