package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.ZeroSafeTimeConverter;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class ZeroSafeTimeConverterTest {

  @Test
  void convertsZeroTimesToEmptyOptionals() {
    assertThat(ZeroSafeTimeConverter.convert("0000")).isEmpty();
  }

  @Test
  void convertsNonZeroTimesToLocalTimes() {
    assertThat(ZeroSafeTimeConverter.convert("0001")).contains(LocalTime.of(0, 1));
  }
}