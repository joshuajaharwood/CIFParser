//fixme: idk what i was doing with this...r
//package com.joshuaharwood.cifparser.postprocessing;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.joshuaharwood.cifparser.parsing.files.CifDefaultMultithreadedProcessor;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Path;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class CifPostprocessorImplTest {
//
//  private static final URL TEST_CIF_PATH = Thread.currentThread()
//    .getContextClassLoader()
//    .getResource("toc-full.CIF");
//
//  @Test
//  void postprocess() throws URISyntaxException, IOException {
//    assertThat(TEST_CIF_PATH).isNotNull();
//
//    var records = new CifDefaultMultithreadedProcessor().process(Path.of(TEST_CIF_PATH.toURI()));
//
//    var y = CifPostprocessorImpl.postprocess(records);
//  }
//}