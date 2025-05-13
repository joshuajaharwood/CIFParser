package com.joshuaharwood.cifparser.parsing.lines.internal;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.lines.model.TiplocInsert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class TiplocInsertParserTest {

  public static final String GOOD_TI_RECORD = "TIABRDCH 08897678MABERDEEN CLAYHILLS CAR.M.D02075   0XAC                        ";
  public static final String GOOD_TI_RECORD_2 = "TIABRDEEN00897600GABERDEEN                  020712800ABDABERDEEN                ";
  private TiplocInsertParser parser;

  @BeforeEach
  void setUp() {
    parser = new TiplocInsertParser();
  }

  @Test
  void parsesGoodDataSuccessfully() {
    assertThat(parser.parse(GOOD_TI_RECORD)).isEqualTo(new TiplocInsert("ABRDCH",
      (byte) 8,
      "897678",
      'M',
      "ABERDEEN CLAYHILLS CAR.M.D",
      "02075",
      "0",
      "XAC",
      null,
      null));
  }

  @Test
  void parsesGoodDataSuccessfully2() {
    assertThat(parser.parse(GOOD_TI_RECORD_2)).isEqualTo(new TiplocInsert("ABRDEEN",
      (byte) 0,
      "897600",
      'G',
      "ABERDEEN",
      "02071",
      "2800",
      "ABD",
      "ABERDEEN",
      null));
  }
}