//TODO: complete me!
//package com.joshuaharwood.cifparser.records.parser;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.joshuaharwood.cifparser.records.model.HeaderRecord;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class HeaderRecordParserTest {
//
//  private HeaderRecordParser parser;
//
//  @BeforeEach
//  public void setUp() {
//    parser = new HeaderRecordParser();
//  }
//
//  @Test
//  void parse() {
//    final String input = "HDTPS.UDFROC1.PD2311242411232032DFROC1H       FA241123231124                    ";
//
//    HeaderRecord expected = new HeaderRecord("TPS.UDFROC1.PD231124",);
//    HeaderRecord actual = parser.parse(input);
//
//    assertThat(actual).isEqualTo(expected);
//  }
//}