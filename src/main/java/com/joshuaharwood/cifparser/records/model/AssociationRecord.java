package com.joshuaharwood.cifparser.records.model;

import com.joshuaharwood.cifparser.records.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.records.model.enums.STPIndicator;
import com.joshuaharwood.cifparser.records.model.enums.TransactionType;
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

}
