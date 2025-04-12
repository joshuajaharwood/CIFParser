import org.jspecify.annotations.NullMarked;

@NullMarked
module CIFParser {
  requires org.jspecify;
  requires org.slf4j;
  requires one.util.streamex;
  exports com.joshuaharwood.cifparser.parsing.lines;
  exports com.joshuaharwood.cifparser.parsing.files;
  exports com.joshuaharwood.cifparser.parsing.lines.model;
  exports com.joshuaharwood.cifparser.parsing.lines.model.enums;
  exports com.joshuaharwood.cifparser.parsing.lines.model.exceptions;
}