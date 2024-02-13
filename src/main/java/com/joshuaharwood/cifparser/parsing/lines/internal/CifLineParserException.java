package com.joshuaharwood.cifparser.parsing.lines.internal;

public class CifLineParserException extends RuntimeException {

  public CifLineParserException(String message, Exception e) {
    super(message, e);
  }
}
