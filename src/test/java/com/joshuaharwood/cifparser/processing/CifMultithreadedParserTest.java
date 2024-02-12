package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CifMultithreadedParserTest {

  private CifMultithreadedParser cifMultithreadedParser;

  @BeforeEach
  void setUp() {
    cifMultithreadedParser = new CifMultithreadedParser();
  }

  @Test
  void parseCifRecords() throws IOException {
    URL testCifPath = Thread.currentThread().getContextClassLoader().getResource("test-full.CIF");

    assertThat(testCifPath).isNotNull();

    List<CifRecord> records = cifMultithreadedParser.parseCifRecords(Path.of(testCifPath.getFile()))
        .join()
        .toList();

    assertThat(records).hasSize(62);
  }

  //  @Disabled("Used for approximate manual benchmarking. Disabled by default")
  @Test
  void parseEntireCifFullExtract() throws IOException {
    /*
     To use this, you'll need to download the latest CIF extract yourself and put it in the test 
     resources.
    */
    URL testCifPath = Thread.currentThread().getContextClassLoader().getResource("toc-full.CIF");

    assertThat(testCifPath).isNotNull();

//    final LocalDateTime before = LocalDateTime.now();
    
    CompletableFuture<Stream<CifRecord>> future = cifMultithreadedParser.parseCifRecords(Path.of(
        testCifPath.getFile()));
    
//    assertThat(future).
//    final LocalDateTime after = LocalDateTime.now();

//    System.out.printf("CifFileParser benchmark time elapsed: %s", Duration.between(before, after));
  }
}