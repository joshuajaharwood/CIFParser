package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.google.common.collect.ImmutableList;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface AssociationField<T> extends RowField<T> permits
  RecordIdentityField, TransactionTypeField, BaseUidField, AssociationUidField,
  AssociationStartDateField, AssociationEndDateField, AssociationDaysField,
  AssociationCategoryField, AssociationDateIndicatorField, AssociationLocationField,
  BaseLocationSuffixField, AssociationLocationSuffixField, DiagramTypeField,
  AssociationTypeField, FillerField, StpIndicatorField {

  class Instances {

    static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    static final TransactionTypeField TRANSACTION_TYPE = new TransactionTypeField();
    static final BaseUidField BASE_UID = new BaseUidField();
    static final AssociationUidField ASSOCIATION_UID = new AssociationUidField();
    static final AssociationStartDateField ASSOCIATION_START_DATE = new AssociationStartDateField();
    static final AssociationEndDateField ASSOCIATION_END_DATE = new AssociationEndDateField();
    static final AssociationDaysField ASSOCIATION_DAYS = new AssociationDaysField();
    static final AssociationCategoryField ASSOCIATION_CATEGORY = new AssociationCategoryField();
    static final AssociationDateIndicatorField ASSOCIATION_DATE_INDICATOR = new AssociationDateIndicatorField();
    static final AssociationLocationField ASSOCIATION_LOCATION = new AssociationLocationField();
    static final BaseLocationSuffixField BASE_LOCATION_SUFFIX = new BaseLocationSuffixField();
    static final AssociationLocationSuffixField ASSOCIATION_LOCATION_SUFFIX = new AssociationLocationSuffixField();
    static final DiagramTypeField DIAGRAM_TYPE = new DiagramTypeField();
    static final AssociationTypeField ASSOCIATION_TYPE = new AssociationTypeField();
    static final FillerField FILLER = new FillerField();
    static final StpIndicatorField STP_INDICATOR = new StpIndicatorField();
    private static final ImmutableList<AssociationField<?>> ALL_INSTANCES = ImmutableList.of(
      RECORD_IDENTITY,
      TRANSACTION_TYPE,
      BASE_UID,
      ASSOCIATION_UID,
      ASSOCIATION_START_DATE,
      ASSOCIATION_END_DATE,
      ASSOCIATION_DAYS,
      ASSOCIATION_CATEGORY,
      ASSOCIATION_DATE_INDICATOR,
      ASSOCIATION_LOCATION,
      BASE_LOCATION_SUFFIX,
      ASSOCIATION_LOCATION_SUFFIX,
      DIAGRAM_TYPE,
      ASSOCIATION_TYPE,
      FILLER,
      STP_INDICATOR);

    private Instances() {
    }

    public static ImmutableList<AssociationField<?>> getAll() {
      return ALL_INSTANCES;
    }
  }
}