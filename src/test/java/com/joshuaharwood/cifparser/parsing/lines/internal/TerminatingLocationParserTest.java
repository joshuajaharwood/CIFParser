package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class TerminatingLocationParserTest {

  private static final String GOOD_LT_RECORD = "LTFALKRKG 1734 17341     TF                                                     ";
  private TerminatingLocationParser parser;

  @BeforeEach
  void setUp() {
    parser = new TerminatingLocationParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    assertThat(parser.parse(GOOD_LT_RECORD)).usingRecursiveComparison()
                                            .isEqualTo(new TerminatingLocation("FALKRKG",
                                                LocalTime.of(17, 34),
                                                LocalTime.of(17, 34),
                                                "1",
                                                null,
                                                "TF",
                                                null));
  }
}