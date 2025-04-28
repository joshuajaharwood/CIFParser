package com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.basicschedule;

import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DefaultStringConverter;

public non-sealed class ServiceBrandingField implements BasicScheduleField<String> {

  private static final DefaultStringConverter CONVERTER = DefaultStringConverter.getInstance();

  ServiceBrandingField() {
  }

  @Override
  public int startIndex() {
    return 74;
  }

  @Override
  public String name() {
    return "SERVICE_BRANDING";
  }

  @Override
  public int length() {
    return 4;
  }

  @Override
  public boolean isRequired() {
    return false;
  }

  @Override
  public String convert(String raw) {
    return CONVERTER.apply(raw);
  }


  @Override
  public String toString() {
    return "ServiceBrandingField[]";
  }

}
