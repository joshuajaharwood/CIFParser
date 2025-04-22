package com.joshuaharwood.cifparser.parsing.lines.internal;

import static com.joshuaharwood.cifparser.parsing.lines.internal.Converter.convert;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.CurrentFileReferenceField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.DateOfExtractField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.FileMainframeIdentityField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.HeaderField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.HeaderField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.LastFileReferenceField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.RecordIdentityField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.SpareField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.TimeOfExtractField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.UpdateIndicatorField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.UserEndDateField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.UserStartDateField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.header.VersionField;
import com.joshuaharwood.cifparser.parsing.lines.model.Header;

public final class HeaderParser implements RecordSpecificParser<Header> {

  public Header parse(String record) {
    final var builder = new Header.Builder();

    for (HeaderField<?> headerField : HeaderField.Instances.getAll()) {
      switch (headerField) {
        case RecordIdentityField _ -> {
        }
        case CurrentFileReferenceField v -> builder.setCurrentFileReference(convert(v, record));
        case DateOfExtractField v -> builder.setDateOfExtract(convert(v, record));
        case FileMainframeIdentityField v -> builder.setFileMainframeIdentity(convert(v, record));
        case LastFileReferenceField v -> builder.setLastFileReference(convert(v, record));
        case SpareField v -> builder.setSpare(convert(v, record));
        case TimeOfExtractField v -> builder.setTimeOfExtract(convert(v, record));
        case UpdateIndicatorField v -> builder.setUpdateIndicator(convert(v, record));
        case UserStartDateField v -> builder.setUserStartDate(convert(v, record));
        case UserEndDateField v -> builder.setUserEndDate(convert(v, record));
        case VersionField v -> builder.setVersion(convert(v, record));
      }
    }

    return builder.createHeader();
  }
}
