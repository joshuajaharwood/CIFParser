package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.Association;
import com.joshuaharwood.cifparser.parsing.model.Association.AssociationCategory;
import com.joshuaharwood.cifparser.parsing.model.Association.AssociationDateIndicator;
import com.joshuaharwood.cifparser.parsing.model.Association.AssociationType;
import com.joshuaharwood.cifparser.parsing.model.Association.DiagramType;
import com.joshuaharwood.cifparser.parsing.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class CifLineParserTest {

  private static final String AA_RECORD = "AANC01484C014852312102405260000001NPSKNGX     TO                               P";
  private CifLineParser parser;

  @BeforeEach
  public void setUp() {
    parser = new CifLineParser();
  }

  @Test
  void parseAssociationRecord() {
    assertThat(parser.parseLine(AA_RECORD)).isEqualTo(new Association(TransactionType.NEW,
        "C01484",
        "C01485",
        LocalDate.of(2023, 12, 10),
        LocalDate.of(2024, 5, 26),
        Set.of(DayOfWeek.SUNDAY),
        AssociationCategory.NEXT,
        AssociationDateIndicator.STANDARD,
        "KNGX",
        null,
        null,
        DiagramType.T,
        AssociationType.OPERATING_USE_ONLY,
        StpIndicator.PERMANENT_ASSOCIATION));
  }
}