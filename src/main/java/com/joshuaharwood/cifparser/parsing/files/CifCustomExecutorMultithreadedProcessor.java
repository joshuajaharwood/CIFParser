package com.joshuaharwood.cifparser.parsing.files;

import static com.pivovarit.collectors.ParallelCollectors.parallel;
import static java.util.stream.Collectors.toList;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
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
import org.jetbrains.annotations.Nullable;

public class CifCustomExecutorMultithreadedProcessor implements
  CifProcessor<Path, CompletableFuture<List<CifRecord>>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();
  private final CifMultithreadedProcessorConfig config;

  public CifCustomExecutorMultithreadedProcessor() {
    this(null);
  }

  public CifCustomExecutorMultithreadedProcessor(@Nullable CifCustomExecutorMultithreadedProcessor.CifMultithreadedProcessorConfig config) {
    this.config = config;
  }

  private static CompletableFuture<List<CifRecord>> usingDefaultExecutor(@NotNull BufferedReader b) {
    return b.lines().collect(parallel(CIF_LINE_PARSER::parseLine, toList()));
  }

  private static CompletableFuture<List<CifRecord>> usingCustomExecutor(@NotNull BufferedReader b,
    @NotNull CifCustomExecutorMultithreadedProcessor.CifMultithreadedProcessorConfig config) {
    return b.lines()
      .collect(parallel(CIF_LINE_PARSER::parseLine,
        toList(),
        config.executor(),
        config.parallelism()));
  }

  public CompletableFuture<List<CifRecord>> process(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      if (this.config != null) {
        return usingCustomExecutor(b, config);
      } else {
        return usingDefaultExecutor(b);
      }
    }
  }

  public record CifMultithreadedProcessorConfig(@NotNull Executor executor,
                                                @NotNull Integer parallelism) {

    public CifMultithreadedProcessorConfig {
      Objects.requireNonNull(executor);
      Objects.requireNonNull(parallelism);
    }
  }
}

