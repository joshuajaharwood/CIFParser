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
class AssociationParserTest {

  public static final String GOOD_AA_RECORD = "AANC01484C014852312102405260000001NPSKNGX     TO                               P";
  public static final String GOOD_AA_RECORD_2 = "AANC01975C750532312102312310000001   NMPTN    T                                C";
  public static final String GOOD_AA_RECORD_3 = "AANC12684G682792312102402110000001JJSYORK   2 TO                               P";
  private AssociationSpecificParser parser;

  @BeforeEach
  void setUp() {
    parser = new AssociationSpecificParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    assertThat(parser.parse(GOOD_AA_RECORD)).usingRecursiveComparison()
                                            .isEqualTo(new Association(TransactionType.NEW,
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

  @Test
  void parsesGoodDataSuccessfully2() {
    assertThat(parser.parse(GOOD_AA_RECORD_2)).usingRecursiveComparison()
                                              .isEqualTo(new Association(TransactionType.NEW,
                                                  "C01975",
                                                  "C75053",
                                                  LocalDate.of(2023, 12, 10),
                                                  LocalDate.of(2023, 12, 31),
                                                  Set.of(DayOfWeek.SUNDAY),
                                                  null,
                                                  null,
                                                  "NMPTN",
                                                  null,
                                                  null,
                                                  DiagramType.T,
                                                  null,
                                                  StpIndicator.STP_CANCELLATION_OF_PERMANENT_ASSOCIATION));
  }

  @Test
  void parsesGoodDataSuccessfully3() {
    assertThat(parser.parse(GOOD_AA_RECORD_3)).usingRecursiveComparison()
                                              .isEqualTo(new Association(TransactionType.NEW,
                                                  "C12684",
                                                  "G68279",
                                                  LocalDate.of(2023, 12, 10),
                                                  LocalDate.of(2024, 2, 11),
                                                  Set.of(DayOfWeek.SUNDAY),
                                                  AssociationCategory.JOIN,
                                                  AssociationDateIndicator.STANDARD,
                                                  "YORK",
                                                  (byte) 2,
                                                  null,
                                                  DiagramType.T,
                                                  AssociationType.OPERATING_USE_ONLY,
                                                  StpIndicator.PERMANENT_ASSOCIATION));
  }
}