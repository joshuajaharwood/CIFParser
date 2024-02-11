package com.joshuaharwood.cifparser.parsing.parser;

public class CifLineParserException extends RuntimeException {

  public CifLineParserException(String message, Exception e) {
    super(message, e);
  }
}
