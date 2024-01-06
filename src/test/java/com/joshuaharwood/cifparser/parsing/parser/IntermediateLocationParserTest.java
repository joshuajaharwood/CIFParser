package com.joshuaharwood.cifparser.parsing.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.IntermediateLocation;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class IntermediateLocationParserTest {

  public static final String GOOD_LI_RECORD = "LICWLRSSJ           1706 00000000                                               ";
  public static final String GOOD_LI_RECORD_2 = "LICWLRSWJ           1706H00000000      UEG                                      ";
  public static final String GOOD_LI_RECORD_3 = "LIBSHB    1709 1710      17091710         T                                     ";
  public static final String GOOD_LI_RECORD_4 = "LILENZIE  1714 1714H     17141714         T                                     ";
  public static final String GOOD_LI_RECORD_5 = "LICROY              1720 000000001                      1H                      ";
  public static final String GOOD_LI_RECORD_6 = "LIGNHLUJN           1726 00000000                        H                      ";
  public static final String GOOD_LI_RECORD_7 = "LICAMELON 1731 1732      17311732         T                                     ";


  private IntermediateLocationSpecificParser parser;

  @BeforeEach
  void setUp() {
    parser = new IntermediateLocationSpecificParser();
  }

  @Test
  void parsesGoodDataSuccessfully1() {
    final var expected = new IntermediateLocation("CWLRSSJ",
        null,
        null,
        LocalTime.of(17, 6),
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

    assertThat(parser.parse(GOOD_LI_RECORD)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully2() {
    final var expected = new IntermediateLocation("CWLRSWJ",
        null,
        null,
        LocalTime.of(17, 6, 30),
        null,
        null,
        null,
        null,
        "UEG",
        null,
        null,
        null,
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_2)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully3() {
    final var expected = new IntermediateLocation("BSHB",
        LocalTime.of(17, 9),
        LocalTime.of(17, 10),
        null,
        LocalTime.of(17, 9),
        LocalTime.of(17, 10),
        null,
        null,
        null,
        "T",
        null,
        null,
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_3)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully4() {
    final var expected = new IntermediateLocation("LENZIE",
        LocalTime.of(17, 14),
        LocalTime.of(17, 14, 30),
        null,
        LocalTime.of(17, 14),
        LocalTime.of(17, 14),
        null,
        null,
        null,
        "T",
        null,
        null,
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_4)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully5() {
    final var expected = new IntermediateLocation("CROY",
        null,
        null,
        LocalTime.of(17, 20),
        null,
        null,
        "1",
        null,
        null,
        null,
        null,
        // TODO: Check this!
        "1H",
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_5)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully6() {
    final var expected = new IntermediateLocation("GNHLUJN",
        null,
        null,
        LocalTime.of(17, 26),
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        // TODO: check this!
        "H",
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_6)).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void parsesGoodDataSuccessfully7() {
    final var expected = new IntermediateLocation("CAMELON",
        LocalTime.of(17, 31),
        LocalTime.of(17, 32),
        null,
        LocalTime.of(17, 31),
        LocalTime.of(17, 32),
        null,
        null,
        null,
        "T",
        null,
        null,
        null,
        null);

    assertThat(parser.parse(GOOD_LI_RECORD_7)).usingRecursiveComparison().isEqualTo(expected);
  }
}