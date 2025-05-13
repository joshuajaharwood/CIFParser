package com.joshuaharwood.cifparser.parsing.files;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class CifStreamImplProcessor implements CifProcessor<Stream<String>, Stream<CifRecord>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();

  //TODO: are we happy with taking in a Stream of strings here, or should it be another type?
  public Stream<CifRecord> process(Stream<String> rawStrings) {
    return rawStrings.map(CIF_LINE_PARSER::parseLine);
  }
}