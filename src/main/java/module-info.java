module CIFParser {
  requires org.slf4j;
  requires org.jetbrains.annotations;
  requires one.util.streamex;
  requires com.google.common;
  exports com.joshuaharwood.cifparser.parsing.lines;
  exports com.joshuaharwood.cifparser.parsing.files;
  exports com.joshuaharwood.cifparser.parsing.lines.model;
  exports com.joshuaharwood.cifparser.parsing.lines.model.enums;
  exports com.joshuaharwood.cifparser.parsing.lines.model.exceptions;
}