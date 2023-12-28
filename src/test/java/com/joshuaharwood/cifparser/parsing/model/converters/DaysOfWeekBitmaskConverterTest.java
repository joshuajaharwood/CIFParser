package com.joshuaharwood.cifparser.parsing.model.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DaysOfWeekBitmaskConverterTest {

  @Test
  void convert() {

    DaysOfWeekBitmaskConverter.convert("0110011");
  }
}