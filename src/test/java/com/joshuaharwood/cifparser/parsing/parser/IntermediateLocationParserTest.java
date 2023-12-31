package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.IntermediateLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntermediateLocationParserTest {

  public static final String GOOD_LI_RECORD = "LICWLRSSJ           1706 00000000                                               ";
  public static final String GOOD_LI_RECORD_2 = "LICWLRSWJ           1706H00000000      UEG                                      ";
  public static final String GOOD_LI_RECORD_3 = "LIBSHB    1709 1710      17091710         T                                     ";
  public static final String GOOD_LI_RECORD_4 = "LILENZIE  1714 1714H     17141714         T                                     ";
  public static final String GOOD_LI_RECORD_5 = "LICROY              1720 000000001                      1H                      ";
  public static final String GOOD_LI_RECORD_6 = "LIGNHLUJN           1726 00000000                        H                      ";
  public static final String GOOD_LI_RECORD_7 = "LICAMELON 1731 1732      17311732         T                                     ";


  private IntermediateLocationParser parser;

  @BeforeEach
  void setUp() {
    parser = new IntermediateLocationParser();
  }

  @Test
  void parse() {
    final var expected = new IntermediateLocation(null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD)).isEqualTo(expected);
  }
}