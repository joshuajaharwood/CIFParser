package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CifFileParserTest {

  private CifFileParser cifFileParser;

  @BeforeEach
  void setUp() {
    cifFileParser = new CifFileParser();
  }

  @Test
  void parseCifRecords() throws IOException {
    URL testCifPath = Thread.currentThread()
        .getContextClassLoader()
        .getResource("test-full.CIF");

    assertThat(testCifPath).isNotNull();

    final LocalDateTime before = LocalDateTime.now();
    List<CifRecord> records = cifFileParser.parseCifRecords(Path.of(testCifPath.getFile()));
    final LocalDateTime after = LocalDateTime.now();

    System.out.printf("CifFileParser benchmark time elapsed: %s", Duration.between(before, after));

    assertThat(records).hasSize(62);
  }
}