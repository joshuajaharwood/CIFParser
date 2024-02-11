package com.joshuaharwood.cifparser.processing;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.util.List;

public interface CifProcessor<T> {
  List<CifRecord> parseCifRecords(T input) throws Exception;
}
