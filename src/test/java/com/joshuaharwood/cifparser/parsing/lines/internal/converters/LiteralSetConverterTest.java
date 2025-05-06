package com.joshuaharwood.cifparser.parsing.lines.internal.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LiteralSetConverterTest {

  private LiteralSetConverter<@NonNull OperatingCharacteristics> literalSetConverter;

  @BeforeEach
  void setUp() {
    this.literalSetConverter = LiteralSetConverter.getInstance(OperatingCharacteristics.class);
  }

  @Test
  void lookupSetReturnsAllCorrectEnums() {
    assertThat(literalSetConverter.apply("BCDEGM")).containsExactly(OperatingCharacteristics.VACUUM_BRAKED,
      OperatingCharacteristics.TIMED_100_MPH,
      OperatingCharacteristics.DOO,
      OperatingCharacteristics.CONVEYS_MARK_4_COACHES,
      OperatingCharacteristics.TRAINMAN_REQUIRED,
      OperatingCharacteristics.TIMED_110_MPH).isUnmodifiable();
  }

  @Test
  void lookupSetReturnsAllCorrectEnumsWithPaddedInput() {
    assertThat(literalSetConverter.apply(" BCD  ")).containsExactly(OperatingCharacteristics.VACUUM_BRAKED,
      OperatingCharacteristics.TIMED_100_MPH,
      OperatingCharacteristics.DOO).isUnmodifiable();
  }

  @Test
  void lookupSetThrowsIllegalArgumentExceptionWithBadData() {
    // A is not a valid OperatingCharacteristic literal
    assertThatIllegalArgumentException().isThrownBy(() -> literalSetConverter.apply("ACDEGM"))
      .withMessage(
        "Failed to map String for given Literal. [String: A] [Enum: OperatingCharacteristics]");
  }

  @Test
  void lookupSetReturnsEmptySetWithBlankData() {
    assertThat(literalSetConverter.apply("   ")).isUnmodifiable().isEmpty();
  }

  @Test
  void lookupSetThrowsNullPointerExceptionWithNullArgument() {
    //noinspection DataFlowIssue
    assertThatNullPointerException().isThrownBy(() -> literalSetConverter.apply(null));
  }
}