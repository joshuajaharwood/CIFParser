package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.enums.STPIndicator;
import com.joshuaharwood.cifparser.records.model.enums.TransactionType;
import com.joshuaharwood.cifparser.records.model.literals.Literal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public record AssociationRecord(RecordIdentity recordIdentity, String spare,
                                TransactionType transactionType, String mainTrainUid,
                                String associatedTrainUid, LocalDate associationStartDate,
                                LocalDate associationEndDate,
                                Map<DayOfWeek, Boolean> associationDays,
                                AssociationCategory associationCategory,
                                AssociationDateIndicator associationDateIndicator,
                                String associationLocation, byte baseLocationSuffix,
                                byte associationLocationSuffix, DiagramType diagramType,
                                AssociationType associationType, STPIndicator stpIndicator

) implements CIFRecord {

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
