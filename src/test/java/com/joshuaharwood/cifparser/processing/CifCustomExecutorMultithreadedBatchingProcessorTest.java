package com.joshuaharwood.cifparser.processing;

import static org.assertj.core.api.Assertions.assertThat;

import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedBatchingProcessor;
import com.joshuaharwood.cifparser.parsing.files.CifCustomExecutorMultithreadedBatchingProcessor.CifMultithreadedBatchingProcessorConfig;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CifCustomExecutorMultithreadedBatchingProcessorTest {

  private static final URL TEST_CIF_PATH = Thread.currentThread()
    .getContextClassLoader()
    .getResource("test-full.CIF");

  private CifCustomExecutorMultithreadedBatchingProcessor cifCustomExecutorMultithreadedBatchingProcessor;

  @BeforeEach
  void setUp() {
    cifCustomExecutorMultithreadedBatchingProcessor = new CifCustomExecutorMultithreadedBatchingProcessor(
      new CifMultithreadedBatchingProcessorConfig(
        ForkJoinPool.commonPool(),
        Runtime.getRuntime().availableProcessors() - 1));
  }

  @Test
  void parseCifRecords()
    throws IOException, ExecutionException, InterruptedException, URISyntaxException {
    assertThat(TEST_CIF_PATH).isNotNull();

    List<CifRecord> records = cifCustomExecutorMultithreadedBatchingProcessor.process(Path.of(
      TEST_CIF_PATH.toURI())).get();

    assertThat(records).hasSize(62);
  }
}