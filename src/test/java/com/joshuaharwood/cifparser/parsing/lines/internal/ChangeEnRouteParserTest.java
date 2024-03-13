package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.lines.model.ChangeEnRoute;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class ChangeEnRouteParserTest {

  public static final String CHANGE_EN_ROUTE_RECORD = "CRLENZIE  OO2N75    123578903 DMUE   090      S                                 ";
  private ChangeEnRouteParser parser;

  @BeforeEach
  void setUp() {
    parser = new ChangeEnRouteParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    assertThat(parser.parse(CHANGE_EN_ROUTE_RECORD))
                                                    .isEqualTo(new ChangeEnRoute("LENZIE",
                                                        TrainCategory.ORDINARY_PASSENGER,
                                                        "2N75",
                                                        null,
                                                        (byte) 1,
                                                        "23578903",
                                                        null,
                                                        PowerType.DIESEL_MECHANICAL_MULTIPLE_UNIT,
                                                        "E",
                                                        90,
                                                        Collections.emptySet(),
                                                        SeatingClass.STANDARD,
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        null));
  }
}