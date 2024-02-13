package com.joshuaharwood.cifparser.parsing.files;

public interface CifProcessor<I, O> {
  O parseCifRecords(I input) throws Exception;
}
