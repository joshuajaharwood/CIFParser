package com.joshuaharwood.cifparser.processing;

public interface CifProcessor<I, O> {
  O parseCifRecords(I input) throws Exception;
}
