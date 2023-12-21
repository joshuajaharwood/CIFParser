package com.joshuaharwood.cifparser.records.parser;

import com.joshuaharwood.cifparser.records.model.CIFRecord;

public sealed interface RecordParser<T extends CIFRecord> permits HeaderRecordParser {
  T parse(String record);

  Class<T> getRecordType();
}
