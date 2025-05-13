package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class ZeroSafeTimeConverterTest {
  private static final ZeroSafeTimeConverter ZERO_SAFE_TIME_CONVERTER = ZeroSafeTimeConverter.getInstance();

  @Test
  void convertsZeroTimesToEmptyOptionals() {
    assertThat(ZERO_SAFE_TIME_CONVERTER.apply("0000")).isEmpty();
  }

  @Test
  void convertsNonZeroTimesToLocalTimes() {
    assertThat(ZERO_SAFE_TIME_CONVERTER.apply("0001")).contains(LocalTime.of(0, 1));
  }
}