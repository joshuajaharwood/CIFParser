package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.tiploc.insert;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface TiplocInsertField<T> extends RowField<T> permits
  RecordIdentityField, TiplocCodeField, CapitalsField, NationalLocationCodeField,
  NlcCheckCharacterField, TpsDescriptionField, StanoxField, PoMcpCodeField,
  CrsCodeField, DescriptionField, SpareField {

  class Instances {
    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TiplocCodeField TIPLOC_CODE = new TiplocCodeField();
    public static final CapitalsField CAPITALS = new CapitalsField();
    public static final NationalLocationCodeField NATIONAL_LOCATION_CODE = new NationalLocationCodeField();
    public static final NlcCheckCharacterField NLC_CHECK_CHARACTER = new NlcCheckCharacterField();
    public static final TpsDescriptionField TPS_DESCRIPTION = new TpsDescriptionField();
    public static final StanoxField STANOX = new StanoxField();
    public static final PoMcpCodeField PO_MCP_CODE = new PoMcpCodeField();
    public static final CrsCodeField CRS_CODE = new CrsCodeField();
    public static final DescriptionField DESCRIPTION = new DescriptionField();
    public static final SpareField SPARE = new SpareField();

    private static final ImmutableList<TiplocInsertField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      TIPLOC_CODE,
      CAPITALS,
      NATIONAL_LOCATION_CODE,
      NLC_CHECK_CHARACTER,
      TPS_DESCRIPTION,
      STANOX,
      PO_MCP_CODE,
      CRS_CODE,
      DESCRIPTION,
      SPARE);

    private Instances() {
    }

    public static ImmutableList<TiplocInsertField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}