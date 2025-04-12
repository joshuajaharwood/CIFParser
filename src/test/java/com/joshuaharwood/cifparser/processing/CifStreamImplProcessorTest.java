package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.files.CifStreamImplProcessor;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CifStreamImplProcessorTest {

  private static final URL TEST_CIF_PATH = Thread.currentThread()
    .getContextClassLoader()
    .getResource("test-full.CIF");

  /**
   * To use this, you'll need to download the latest CIF extract yourself and put it in the test
   * resources.
   */
  private static final URL FULL_CIF_PATH = Thread.currentThread()
    .getContextClassLoader()
    .getResource("toc-full.CIF");

  private CifStreamImplProcessor cifStreamImplProcessorPlatformThreads;

  @BeforeEach
  void setUp() {
    cifStreamImplProcessorPlatformThreads = new CifStreamImplProcessor();
  }

  @Test
  void parseCifRecords() throws IOException, URISyntaxException {
    assertThat(TEST_CIF_PATH).isNotNull();

    List<CifRecord> records = cifStreamImplProcessorPlatformThreads.process(Path.of(
      TEST_CIF_PATH.toURI()));

    assertThat(records).hasSize(62);
  }
}