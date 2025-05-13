package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.files.CifStreamImplProcessor;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CifStreamImplProcessorTest {

  private static final Path FULL_CIF_PATH = Path.of("/Users/josh/Downloads/ttis293/ttisf293.mca");

  private CifStreamImplProcessor cifStreamImplProcessorPlatformThreads;

  @BeforeEach
  void setUp() {
    cifStreamImplProcessorPlatformThreads = new CifStreamImplProcessor();
  }

  @Test
  void parseCifRecords() throws IOException {
    
    List<CifRecord> records;

    try (BufferedReader b = Files.newBufferedReader(FULL_CIF_PATH, StandardCharsets.US_ASCII)) {
      records = cifStreamImplProcessorPlatformThreads.process(b.lines()).toList();
    }

    assertThat(records).hasSize(8245937);
  }
}