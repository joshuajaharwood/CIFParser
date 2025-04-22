package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.trailer;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;
import com.joshuaharwood.cifparser.parsing.lines.internal.converters.LiteralConverter;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import java.util.function.Function;

public record SpareField() implements TrailerField<String> {
  
  @Override
  public int startIndex() {
    return 2;
  }

  @Override
  public String name() {
    return "SPARE";
  }

  @Override
  public int length() {
    return 78;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public Function<String, String> converter() {
    return DefaultStringConverter.getInstance();
  }
}
