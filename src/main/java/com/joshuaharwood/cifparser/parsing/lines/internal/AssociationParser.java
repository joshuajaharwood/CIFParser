//package com.joshuaharwood.cifparser.parsing.lines.internal;
//
//import static com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup.lookup;
//
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.DaysOfWeekBitmaskConverter;
//import com.joshuaharwood.cifparser.parsing.lines.internal.converters.InverseDateConverter;
//import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.AssociationFields;
//import com.joshuaharwood.cifparser.parsing.lines.internal.literals.LiteralLookup;
//import com.joshuaharwood.cifparser.parsing.lines.model.Association;
//import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationCategory;
//import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationDateIndicator;
//import com.joshuaharwood.cifparser.parsing.lines.model.Association.AssociationType;
//import com.joshuaharwood.cifparser.parsing.lines.model.Association.DiagramType;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
//import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
//import java.util.Map;
//
//public final class AssociationParser implements RecordSpecificParser<Association> {
//
//  @Override
//  public Association parse(String record) {
//    final Map<AssociationFields, String> parsedValues = StringParser.parse(record,
//      AssociationFields.values());
//
//    return new Association(lookup(TransactionType.class,
//      parsedValues.get(AssociationFields.TRANSACTION_TYPE)).orElse(null),
//      ifPresent(parsedValues.get(AssociationFields.BASE_UID)).orElse(null),
//      ifPresent(parsedValues.get(AssociationFields.ASSOCIATION_UID)).orElse(null),
//      InverseDateConverter.apply(parsedValues.get(AssociationFields.ASSOCIATION_START_DATE))
//        .orElse(null),
//      InverseDateConverter.apply(parsedValues.get(AssociationFields.ASSOCIATION_END_DATE))
//        .orElse(null),
//      DaysOfWeekBitmaskConverter.apply(parsedValues.get(AssociationFields.ASSOCIATION_DAYS)),
//      LiteralLookup.lookup(AssociationCategory.class,
//        parsedValues.get(AssociationFields.ASSOCIATION_CATEGORY)).orElse(null),
//      LiteralLookup.lookup(AssociationDateIndicator.class,
//        parsedValues.get(AssociationFields.ASSOCIATION_DATE_INDICATOR)).orElse(null),
//      ifPresent(parsedValues.get(AssociationFields.ASSOCIATION_LOCATION)).orElse(null),
//      ifPresent(parsedValues.get(AssociationFields.BASE_LOCATION_SUFFIX)).map(Byte::valueOf)
//        .orElse(null),
//      ifPresent(parsedValues.get(AssociationFields.ASSOCIATION_LOCATION_SUFFIX)).map(Byte::valueOf)
//        .orElse(null),
//      LiteralLookup.lookup(DiagramType.class, parsedValues.get(AssociationFields.DIAGRAM_TYPE))
//        .orElse(null),
//      LiteralLookup.lookup(AssociationType.class,
//        parsedValues.get(AssociationFields.ASSOCIATION_TYPE)).orElse(null),
//      LiteralLookup.lookup(StpIndicator.class, parsedValues.get(AssociationFields.STP_INDICATOR))
//        .orElse(null));
//  }
//}
