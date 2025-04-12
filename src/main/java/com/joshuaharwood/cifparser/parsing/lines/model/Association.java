package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public record Association(TransactionType transactionType,
                          String mainTrainUid,
                          String associatedTrainUid,
                          LocalDate associationStartDate,
                          LocalDate associationEndDate,
                          Set<DayOfWeek> associationDays,
                          AssociationCategory associationCategory,
                          AssociationDateIndicator associationDateIndicator,
                          String associationLocation,
                          Byte baseLocationSuffix,
                          Byte associationLocationSuffix,
                          DiagramType diagramType,
                          AssociationType associationType,
                          StpIndicator stpIndicator
) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.ASSOCIATION_RECORD;
  }

  public enum AssociationCategory implements Literal {
    JOIN("JJ"),
    DIVIDE("VV"),
    NEXT("NP");

    private final String literal;

    AssociationCategory(String literal) {
      this.literal = literal;
    }

    public String getLiteral() {
      return literal;
    }
  }

  public enum AssociationDateIndicator implements Literal {
    STANDARD("S"),
    OVER_NEXT_MIDNIGHT("N"),
    OVER_PREVIOUS_MIDNIGHT("P");

    private final String literal;

    AssociationDateIndicator(String literal) {
      this.literal = literal;
    }

    public String getLiteral() {
      return literal;
    }
  }

  public enum DiagramType implements Literal {
    T("T");

    private final String literal;


    DiagramType(String literal) {
      this.literal = literal;
    }

    @Override
    public String getLiteral() {
      return literal;
    }
  }

  public enum AssociationType implements Literal {
    PASSENGER_USE("P"),
    OPERATING_USE_ONLY("O");
    private final String literal;

    AssociationType(String literal) {
      this.literal = literal;
    }

    @Override
    public String getLiteral() {
      return literal;
    }
  }

}
