package com.joshuaharwood.cifparser.processing;

import static com.pivovarit.collectors.ParallelCollectors.parallel;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.parser.CifLineParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CifMultithreadedParser implements
    CifProcessor<Path, CompletableFuture<Stream<CifRecord>>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();
  private final CifMultithreadedParserConfig config;

  public CifMultithreadedParser() {
    this(null);
  }

  public CifMultithreadedParser(@Nullable CifMultithreadedParserConfig config) {
    this.config = config;
  }

  private static CompletableFuture<Stream<CifRecord>> usingDefaultExecutor(BufferedReader b) {
    return b.lines().collect(parallel(CIF_LINE_PARSER::parseLine));
  }

  private static CompletableFuture<Stream<CifRecord>> usingCustomExecutor(BufferedReader b,
      CifMultithreadedParserConfig config) {
    return b.lines()
        .collect(parallel(CIF_LINE_PARSER::parseLine, config.executor(), config.parallelism()));
  }

  public CompletableFuture<Stream<CifRecord>> parseCifRecords(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {

      if (this.config != null) {
        return usingCustomExecutor(b, config);
      } else {
        return usingDefaultExecutor(b);
      }
    }
  }

  public record CifMultithreadedParserConfig(@NotNull Executor executor,
                                             @NotNull Integer parallelism) {

    public CifMultithreadedParserConfig {
      Objects.requireNonNull(executor);
      Objects.requireNonNull(parallelism);
    }
  }
}

