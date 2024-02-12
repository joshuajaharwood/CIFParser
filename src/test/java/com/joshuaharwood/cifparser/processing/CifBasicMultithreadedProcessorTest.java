package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CifBasicMultithreadedProcessorTest {

  /**
   * To use this, you'll need to download the latest CIF extract yourself and put it in the test
   * resources.
   */
  private static final URL FULL_CIF_PATH = Thread.currentThread()
    .getContextClassLoader()
    .getResource("toc-full.CIF");

  private CifBasicMultithreadedProcessor cifBasicMultithreadedProcessor;

  @BeforeEach
  void setUp() {
    this.cifBasicMultithreadedProcessor = new CifBasicMultithreadedProcessor();
  }

  // Last result: PT3.3388724S (!!)
  @Disabled("Used for approximate manual benchmarking. Disabled by default")
  @Test
  void parseCifRecords() throws URISyntaxException, IOException {
    assertThat(FULL_CIF_PATH).isNotNull();

    var beforeTime = LocalDateTime.now();
    List<CifRecord> cifRecords = cifBasicMultithreadedProcessor.parseCifRecords(Path.of(
      FULL_CIF_PATH.toURI()));
    System.out.println(Duration.between(beforeTime, LocalDateTime.now()));

    assertThat(cifRecords).hasSize(7184495);
  }
}