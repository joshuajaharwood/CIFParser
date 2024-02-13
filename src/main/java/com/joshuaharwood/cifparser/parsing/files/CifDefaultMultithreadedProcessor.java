package com.joshuaharwood.cifparser.parsing.files;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CifDefaultMultithreadedProcessor implements CifProcessor<Path, List<CifRecord>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();

  public List<CifRecord> parseCifRecords(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      return b.lines().parallel().map(CIF_LINE_PARSER::parseLine).toList();
    }
  }
}