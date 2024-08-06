package com.joshuaharwood.cifparser.parsing.files;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * A synchronous CifProcessor implementation using the default {@link Stream#parallel()}
 * implementation to parallelise {@link CifRecord} processing.
 *
 * @apiNote {@link Stream#parallel()} uses {@link ForkJoinPool#commonPool()}, which can lead to the
 * common thread pool becoming exhausted if other common thread pool consumers are competing for
 * threads. If this is a concern for you, {@link CifStreamImplProcessor} and
 * {@link CifCustomExecutorMultithreadedBatchingProcessor} allow you to provide your own
 * {@link Executor}.
 */
public class CifStreamExImplProcessor implements CifProcessor<Path, List<CifRecord>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();

  public List<CifRecord> process(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      return b.lines().parallel().map(CIF_LINE_PARSER::parseLine).toList();
    }
  }
}