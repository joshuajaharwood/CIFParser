package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.association.AssociationField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.Association;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationDateIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.DiagramType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public final class AssociationParser implements RecordSpecificParser<Association> {

  private final AssociationRowDefinition fieldDefinitions;

  public AssociationParser() {
    this(AssociationRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public AssociationParser(AssociationRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }


  @Override
  public Association parse(String record) {
    return new Association(fieldDefinitions.transactionType().substringAndConvert(record),
      fieldDefinitions.mainTrainUid().substringAndConvert(record),
      fieldDefinitions.associatedTrainUid().substringAndConvert(record),
      fieldDefinitions.associationStartDate().substringAndConvert(record),
      fieldDefinitions.associationEndDate().substringAndConvert(record),
      fieldDefinitions.associationDays().substringAndConvert(record),
      fieldDefinitions.associationCategory().substringAndConvert(record),
      fieldDefinitions.associationDateIndicator().substringAndConvert(record),
      fieldDefinitions.associationLocation().substringAndConvert(record),
      fieldDefinitions.baseLocationSuffix().substringAndConvert(record),
      fieldDefinitions.associationLocationSuffix().substringAndConvert(record),
      fieldDefinitions.diagramType().substringAndConvert(record),
      fieldDefinitions.associationType().substringAndConvert(record),
      fieldDefinitions.stpIndicator().substringAndConvert(record));
  }

  public record AssociationRowDefinition(RowField<TransactionType> transactionType,
                                         RowField<String> mainTrainUid,
                                         RowField<String> associatedTrainUid,
                                         RowField<LocalDate> associationStartDate,
                                         RowField<LocalDate> associationEndDate,
                                         RowField<Set<DayOfWeek>> associationDays,
                                         RowField<AssociationCategory> associationCategory,
                                         RowField<AssociationDateIndicator> associationDateIndicator,
                                         RowField<String> associationLocation,
                                         RowField<Byte> baseLocationSuffix,
                                         RowField<Byte> associationLocationSuffix,
                                         RowField<DiagramType> diagramType,
                                         RowField<AssociationType> associationType,
                                         RowField<StpIndicator> stpIndicator) {

    public static final AssociationRowDefinition DEFAULT_ROW_DEFINITION = new AssociationRowDefinition(
      Instances.TRANSACTION_TYPE,
      Instances.BASE_UID,
      Instances.ASSOCIATION_UID,
      Instances.ASSOCIATION_START_DATE,
      Instances.ASSOCIATION_END_DATE,
      Instances.ASSOCIATION_DAYS,
      Instances.ASSOCIATION_CATEGORY,
      Instances.ASSOCIATION_DATE_INDICATOR,
      Instances.ASSOCIATION_LOCATION,
      Instances.BASE_LOCATION_SUFFIX,
      Instances.ASSOCIATION_LOCATION_SUFFIX,
      Instances.DIAGRAM_TYPE,
      Instances.ASSOCIATION_TYPE,
      Instances.STP_INDICATOR);
  }
}
