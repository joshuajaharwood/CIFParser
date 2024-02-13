package com.joshuaharwood.cifparser.parsing.files;

import static com.pivovarit.collectors.ParallelCollectors.Batching.parallel;
import static java.util.stream.Collectors.toList;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.internal.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

public class CifCustomExecutorMultithreadedBatchingProcessor implements
  CifProcessor<Path, CompletableFuture<List<CifRecord>>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();
  private final CifMultithreadedBatchingProcessorConfig config;

  public CifCustomExecutorMultithreadedBatchingProcessor(@NotNull CifMultithreadedBatchingProcessorConfig config) {
    this.config = config;
  }

  public CompletableFuture<List<CifRecord>> parseCifRecords(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      return b.lines()
        .collect(parallel(CIF_LINE_PARSER::parseLine,
          toList(),
          config.executor(),
          config.parallelism()));
    }
  }

  public record CifMultithreadedBatchingProcessorConfig(@NotNull Executor executor,
                                                        @NotNull Integer parallelism) {

    public CifMultithreadedBatchingProcessorConfig {
      Objects.requireNonNull(executor);
      Objects.requireNonNull(parallelism);
    }
  }
}

