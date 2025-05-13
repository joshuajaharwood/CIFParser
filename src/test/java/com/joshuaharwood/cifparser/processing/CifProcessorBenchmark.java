package com.joshuaharwood.cifparser.processing;

import com.joshuaharwood.cifparser.parsing.files.CifStreamImplProcessor;
import java.io.BufferedReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@Threads(Threads.MAX)
@BenchmarkMode(Mode.SingleShotTime)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 2)
public class CifProcessorBenchmark {

  private static final CifStreamImplProcessor CIF_CUSTOM_EXECUTOR_MULTITHREADED_PROCESSOR = new CifStreamImplProcessor();

  private static final CifStreamImplProcessor CIF_DEFAULT_MULTITHREADED_PROCESSOR = new CifStreamImplProcessor();

  /**
   * To use this, you'll need to download the latest CIF extract yourself and put it in the test
   * resources.
   */
  private static final Path FULL_CIF_PATH = Path.of("/Users/josh/Downloads/ttis293/ttisf293.mca");

//  static {
//    try {
//      FULL_CIF_PATH = URI.create("").toURL();
//    } catch (MalformedURLException e) {
//      throw new RuntimeException(e);
//    }
//  }
//    Thread.currentThread()
//    .getContextClassLoader()
//    .getResource("toc-full.CIF");

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }

//  @Benchmark
//  public void benchmarkCustomExecutorMultithreadedProcessor(Blackhole bh) throws Exception {
//    bh.consume(CIF_CUSTOM_EXECUTOR_MULTITHREADED_PROCESSOR.process(FULL_CIF_PATH));
//  }

  @Benchmark
  public void benchmarkDefaultMultithreadedProcessor(Blackhole bh) throws Exception {

    try (BufferedReader b = Files.newBufferedReader(FULL_CIF_PATH, StandardCharsets.US_ASCII)) {
      bh.consume(CIF_DEFAULT_MULTITHREADED_PROCESSOR.process(b.lines()));
    }
  }

  private Path getCifFileUri() {
    try {
      return Path.of(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader()
        .getResource("toc-full.CIF")).toURI());
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
