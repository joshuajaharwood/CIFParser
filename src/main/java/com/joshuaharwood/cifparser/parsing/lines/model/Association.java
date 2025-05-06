package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationDateIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.AssociationType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.DiagramType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public record Association(TransactionType transactionType,
                          String mainTrainUid,
                          String associatedTrainUid,
                          LocalDate associationStartDate,
                          LocalDate associationEndDate,
                          Set<DayOfWeek> associationDays,
                          @Nullable AssociationCategory associationCategory,
                          @Nullable AssociationDateIndicator associationDateIndicator,
                          String associationLocation,
                          @Nullable Byte baseLocationSuffix,
                          @Nullable Byte associationLocationSuffix,
                          DiagramType diagramType,
                          @Nullable AssociationType associationType,
                          StpIndicator stpIndicator
) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ASSOCIATION_RECORD;
  }

}
