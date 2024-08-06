package com.joshuaharwood.cifparser.parsing.files;

import com.joshuaharwood.cifparser.parsing.lines.CifLineParser;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import one.util.streamex.StreamEx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CifStreamImplProcessor implements CifProcessor<Path, List<CifRecord>> {

  private static final CifLineParser CIF_LINE_PARSER = new CifLineParser();
  private final ForkJoinPool fjp;

  public CifStreamImplProcessor() {
    this(null);
  }

  public CifStreamImplProcessor(@Nullable ForkJoinPool fjp) {
    this.fjp = fjp;
  }

  private static List<CifRecord> usingCommonForkJoinPool(@NotNull BufferedReader b) {
    return StreamEx.of(b.lines()).parallel().map(CIF_LINE_PARSER::parseLine).toList();
  }

  private static List<CifRecord> usingCustomForkJoinPool(@NotNull BufferedReader b,
    @NotNull ForkJoinPool fjp) {
    return StreamEx.of(b.lines()).parallel(fjp).map(CIF_LINE_PARSER::parseLine).toList();
  }

  public List<CifRecord> process(Path path) throws IOException {
    try (BufferedReader b = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
      if (fjp != null) {
        return usingCustomForkJoinPool(b, fjp);
      } else {
        return usingCommonForkJoinPool(b);
      }
    }
  }
}

