package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedBatchingProcessor;
import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedBatchingProcessor.CifMultithreadedBatchingProcessorConfig;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.CifRecord;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CifCustomExecutorMultithreadedBatchingProcessorTest {

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

  private CifCustomExecutorMultithreadedBatchingProcessor cifCustomExecutorMultithreadedBatchingProcessor;

  @BeforeEach
  void setUp() {
    cifCustomExecutorMultithreadedBatchingProcessor = new CifCustomExecutorMultithreadedBatchingProcessor(new CifMultithreadedBatchingProcessorConfig(
      ForkJoinPool.commonPool(),
      Runtime.getRuntime().availableProcessors() - 1));
  }

  @Test
  void parseCifRecords()
    throws IOException, ExecutionException, InterruptedException, URISyntaxException {
    assertThat(TEST_CIF_PATH).isNotNull();

    List<CifRecord> records = cifCustomExecutorMultithreadedBatchingProcessor.parseCifRecords(Path.of(
      TEST_CIF_PATH.toURI())).get();

    assertThat(records).hasSize(62);
  }

  // Last result: PT9.7279543S
  @Disabled("Used for approximate manual benchmarking. Disabled by default")
  @Test
  void parseEntireCifFullExtractWithPlatformThreads()
    throws IOException, URISyntaxException, ExecutionException, InterruptedException {
    assertThat(FULL_CIF_PATH).isNotNull();

    var beforeTime = LocalDateTime.now();
    var records = cifCustomExecutorMultithreadedBatchingProcessor.parseCifRecords(Path.of(FULL_CIF_PATH.toURI()))
      .get();

    System.out.println(Duration.between(beforeTime, LocalDateTime.now()));

    assertThat(records).hasSize(7184495);
  }
}