package com.joshuaharwood.cifparser.processing;

import com.joshuaharwood.cifparser.parsing.model.CifRecord;
import java.util.List;

public interface CifProcessor<I, O> {
  O parseCifRecords(I input) throws Exception;
}
