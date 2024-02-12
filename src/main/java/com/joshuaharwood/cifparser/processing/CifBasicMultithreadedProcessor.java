package com.joshuaharwood.cifparser.processing;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.parser.CifLineParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CifBasicMultithreadedProcessor implements CifProcessor<Path, List<CifRecord>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();

  public List<CifRecord> parseCifRecords(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      return b.lines().parallel().map(CIF_LINE_PARSER::parseLine).toList();
    }
  }
}