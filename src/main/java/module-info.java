module CIFParser {
  requires transitive parallel.collectors;
  requires transitive org.slf4j;
  requires transitive org.jetbrains.annotations;
  exports com.joshuaharwood.cifparser.parsing.lines;
  exports com.joshuaharwood.cifparser.parsing.files;
  exports com.joshuaharwood.cifparser.parsing.lines.internal.model;
  exports com.joshuaharwood.cifparser.parsing.lines.internal.model.enums;
}