package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedProcessor;
import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedProcessor.CifMultithreadedProcessorConfig;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
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

class CifCustomExecutorMultithreadedProcessorTest {

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

  private CifCustomExecutorMultithreadedProcessor cifCustomExecutorMultithreadedProcessorPlatformThreads;

  private CifCustomExecutorMultithreadedProcessor cifCustomExecutorMultithreadedProcessorVirtualThreads;

//  ForkJoinPool.commonPool()

  @BeforeEach
  void setUp() {
    cifCustomExecutorMultithreadedProcessorPlatformThreads = new CifCustomExecutorMultithreadedProcessor(new CifMultithreadedProcessorConfig(
      new ForkJoinPool(),
      Runtime.getRuntime().availableProcessors() - 1));

    // We use virtual threads when not provided with config
    cifCustomExecutorMultithreadedProcessorVirtualThreads = new CifCustomExecutorMultithreadedProcessor();
  }

  @Test
  void parseCifRecords()
    throws IOException, ExecutionException, InterruptedException, URISyntaxException {
    assertThat(TEST_CIF_PATH).isNotNull();

    List<CifRecord> records = cifCustomExecutorMultithreadedProcessorVirtualThreads.process(Path.of(
      TEST_CIF_PATH.toURI())).get();

    assertThat(records).hasSize(62);
  }
}