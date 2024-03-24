package com.joshuaharwood.cifparser.postprocessing;

public interface CifPostprocessor<I, O> {
  O process(I input);
}
