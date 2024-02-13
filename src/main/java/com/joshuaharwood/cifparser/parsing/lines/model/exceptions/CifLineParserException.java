package com.joshuaharwood.cifparser.parsing.lines.model.exceptions;

public class CifLineParserException extends RuntimeException {

  public CifLineParserException(String message, Exception e) {
    super(message, e);
  }
}
