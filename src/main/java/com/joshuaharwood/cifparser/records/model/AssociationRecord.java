package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.literals.CharLiteral;
import com.joshuaharwood.cifparser.records.model.literals.StringLiteral;
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

  public enum TransactionType implements CharLiteral {
    NEW('N'), DELETE('D'), REVISE('R');

    private final char literal;

    TransactionType(char literal) {
      this.literal = literal;
    }

    public char getLiteral() {
      return literal;
    }
  }

  public enum AssociationCategory implements StringLiteral {
    JOIN("JJ"), DIVIDE("VV"), NEXT("NP");

    private final String literal;

    AssociationCategory(String literal) {
      this.literal = literal;
    }

    public String getLiteral() {
      return literal;
    }
  }

  public enum AssociationDateIndicator implements CharLiteral {
    STANDARD('S'), OVER_NEXT_MIDNIGHT('N'), OVER_PREVIOUS_MIDNIGHT('P');

    private final char literal;

    AssociationDateIndicator(char literal) {
      this.literal = literal;
    }

    public char getLiteral() {
      return literal;
    }
  }

  public enum DiagramType implements CharLiteral {
    T('T');

    private final char literal;


    DiagramType(char literal) {
      this.literal = literal;
    }

    @Override
    public char getLiteral() {
      return literal;
    }
  }

  public enum AssociationType implements CharLiteral {
    PASSENGER_USE('P'), OPERATING_USE_ONLY('O');
    private final char literal;

    AssociationType(char literal) {
      this.literal = literal;
    }

    @Override
    public char getLiteral() {
      return literal;
    }
  }

  public enum STPIndicator implements CharLiteral {
    STP_CANCELLATION_OF_PERMANENT_ASSOCIATION('C'), NEW_STP_ASSOCIATION('N'), STP_OVERLAY_OF_PERMANENT_ASSOCIATION(
        'O'), PERMANENT_ASSOCIATION('P');

    private final char literal;

    STPIndicator(char literal) {
      this.literal = literal;
    }

    @Override
    public char getLiteral() {
      return literal;
    }
  }
}
