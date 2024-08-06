package com.joshuaharwood.cifparser.processing;

import com.joshuaharwood.cifparser.parsing.files.CifStreamImplProcessor;
import com.joshuaharwood.cifparser.parsing.files.CifStreamExImplProcessor;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
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

  private static final CifStreamImplProcessor CIF_CUSTOM_EXECUTOR_MULTITHREADED_PROCESSOR = new CifStreamImplProcessor(
    new ForkJoinPool());

  private static final CifStreamExImplProcessor CIF_DEFAULT_MULTITHREADED_PROCESSOR = new CifStreamExImplProcessor();

  /**
   * To use this, you'll need to download the latest CIF extract yourself and put it in the test
   * resources.
   */
  private static final URL FULL_CIF_PATH = Thread.currentThread()
    .getContextClassLoader()
    .getResource("toc-full.CIF");

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }

  @Benchmark
  public void benchmarkCustomExecutorMultithreadedProcessor(Blackhole bh) throws Exception {
    assert FULL_CIF_PATH != null;

    bh.consume(CIF_CUSTOM_EXECUTOR_MULTITHREADED_PROCESSOR.process(getCifFileUri()));
  }

  @Benchmark
  public void benchmarkDefaultMultithreadedProcessor(Blackhole bh) throws Exception {
    assert FULL_CIF_PATH != null;

    bh.consume(CIF_DEFAULT_MULTITHREADED_PROCESSOR.process(getCifFileUri()));
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
