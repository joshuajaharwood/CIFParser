package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;

public sealed interface AssociationField<T> extends RowField<T> permits
  RecordIdentityField, TransactionTypeField, BaseUidField, AssociationUidField,
  AssociationStartDateField, AssociationEndDateField, AssociationDaysField,
  AssociationCategoryField, AssociationDateIndicatorField, AssociationLocationField,
  BaseLocationSuffixField, AssociationLocationSuffixField, DiagramTypeField,
  AssociationTypeField, FillerField, StpIndicatorField {

  class Instances {

    public static final RecordIdentityField RECORD_IDENTITY = new RecordIdentityField();
    public static final TransactionTypeField TRANSACTION_TYPE = new TransactionTypeField();
    public static final BaseUidField BASE_UID = new BaseUidField();
    public static final AssociationUidField ASSOCIATION_UID = new AssociationUidField();
    public static final AssociationStartDateField ASSOCIATION_START_DATE = new AssociationStartDateField();
    public static final AssociationEndDateField ASSOCIATION_END_DATE = new AssociationEndDateField();
    public static final AssociationDaysField ASSOCIATION_DAYS = new AssociationDaysField();
    public static final AssociationCategoryField ASSOCIATION_CATEGORY = new AssociationCategoryField();
    public static final AssociationDateIndicatorField ASSOCIATION_DATE_INDICATOR = new AssociationDateIndicatorField();
    public static final AssociationLocationField ASSOCIATION_LOCATION = new AssociationLocationField();
    public static final BaseLocationSuffixField BASE_LOCATION_SUFFIX = new BaseLocationSuffixField();
    public static final AssociationLocationSuffixField ASSOCIATION_LOCATION_SUFFIX = new AssociationLocationSuffixField();
    public static final DiagramTypeField DIAGRAM_TYPE = new DiagramTypeField();
    public static final AssociationTypeField ASSOCIATION_TYPE = new AssociationTypeField();
    public static final FillerField FILLER = new FillerField();
    public static final StpIndicatorField STP_INDICATOR = new StpIndicatorField();

    private Instances() {
    }
  }
}