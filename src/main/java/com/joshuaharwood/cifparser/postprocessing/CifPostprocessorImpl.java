//package com.joshuaharwood.cifparser.postprocessing;
//
//import com.joshuaharwood.cifparser.parsing.lines.model.Association;
//import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
//import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
//import com.joshuaharwood.cifparser.parsing.lines.model.ChangeEnRoute;
//import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
//import com.joshuaharwood.cifparser.parsing.lines.model.Header;
//import com.joshuaharwood.cifparser.parsing.lines.model.IntermediateLocation;
//import com.joshuaharwood.cifparser.parsing.lines.model.LocationRecord;
//import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
//import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
//import com.joshuaharwood.cifparser.parsing.lines.model.TiplocRecord;
//import com.joshuaharwood.cifparser.parsing.lines.model.Trailer;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import one.util.streamex.StreamEx;
//
//public class CifPostprocessorImpl {
//
//  private CifPostprocessorImpl() {
//  }
//
//  @SuppressWarnings("unchecked")
//  public static CifPostprocessedResult postprocess(List<CifRecord> cifRecords) {
//    Map<PostprocessorMapping, List<List<CifRecord>>> groupedRecords = StreamEx.of(cifRecords)
//      // todo: investigate ForkJoinPool impl across the project. can prob replace parallel collectors with streamex here!
//      .parallel()
//      .groupRuns(CifPostprocessorImpl::groupRecords)
//      .groupingBy(CifPostprocessorImpl::createTypeMap);
//
//    Header h = null;
//    List<TiplocRecord> tiplocRecords = null;
//
//    for (Entry<PostprocessorMapping, List<List<CifRecord>>> mapping : groupedRecords.entrySet()) {
//      switch (mapping.getKey()) {
//        case HEADER -> h = (Header) mapping.getValue().getFirst().getFirst();
//        // fixme: what to do about casting???
//        case TIPLOC -> tiplocRecords = (List) mapping.getValue();
//        case SCHEDULE -> {
//        }
//        case ASSOCIATION -> {
//        }
//        case LOCATION -> {
//        }
//        case TRAILER -> {
//        }
//      }
//    }
//
////    var x = groupedRecords.get(Header.class);
////
//    return new CifPostprocessedResult(h,
//      getByClass(groupedRecords, TiplocRecord.class),
//      null,
//      getByClass(groupedRecords, Association.class),
//      getByClassSingleton(groupedRecords, Trailer.class));
//
//    return null;
//  }
//
////  private static boolean isSingletonRecord(CifRecord r) {
////    return switch (r) {
////      case Association ignored -> false;
////      case BasicSchedule ignored -> false;
////      case BasicScheduleExtended ignored -> false;
////      case Header ignored -> true;
////      case LocationRecord ignored -> false;
////      case TiplocRecord ignored -> false;
////      case Trailer ignored -> true;
////    };
////  }
//
//  private static <T extends CifRecord> PostprocessorMapping createTypeMap(List<T> cifRecords) {
//    if (cifRecords.isEmpty()) {
//      throw new IllegalStateException("Record list cannot be empty.");
//    }
//
//    return PostprocessorMapping.getPostprocessorMappingForCifRecord(cifRecords.getFirst());
//  }
//
//  private static <T extends CifRecord, U extends CifRecord> boolean groupRecords(T current,
//    U next) {
//    return
//      (isScheduleRecord(current) && isScheduleRecord(next) || current.getClass() == next.getClass())
//        && !terminatesGrouping(current);
//  }
//
//  private static boolean isScheduleRecord(CifRecord r) {
//    return switch (r) {
//      case Association ignored -> false;
//      case BasicSchedule ignored -> true;
//      case BasicScheduleExtended ignored -> true;
//      case Header ignored -> false;
//      case LocationRecord ignored -> true;
//      case TiplocRecord ignored -> false;
//      case Trailer ignored -> false;
//    };
//  }
//
//  private static boolean terminatesGrouping(CifRecord r) {
//    return switch (r) {
//      case Association ignored -> false;
//      case BasicSchedule ignored -> false;
//      case BasicScheduleExtended ignored -> false;
//      case Header ignored -> true;
//      case LocationRecord l -> switch (l) {
//        case ChangeEnRoute ignored -> false;
//        case IntermediateLocation ignored -> false;
//        case OriginLocation ignored -> false;
//        case TerminatingLocation ignored -> true;
//      };
//      case TiplocRecord ignored -> false;
//      case Trailer ignored -> true;
//    };
//  }
//
//  private enum PostprocessorMapping {
//    HEADER,
//    TIPLOC,
//    SCHEDULE,
//    ASSOCIATION,
//    LOCATION,
//    TRAILER;
//
//    private static <T extends CifRecord> PostprocessorMapping getPostprocessorMappingForCifRecord(T record) {
//      return switch (record) {
//        case Association ignored -> ASSOCIATION;
//        case BasicSchedule ignored -> SCHEDULE;
//        case Header ignored -> HEADER;
//        case LocationRecord ignored -> LOCATION;
//        case TiplocRecord ignored -> TIPLOC;
//        case Trailer ignored -> TRAILER;
//        default ->
//          throw new IllegalArgumentException("Encountered non-grouping-starting type. [Record: %s]".formatted(
//            record));
//      };
//    }
//  }
//
////  private static Object handleScheduleStart(BasicSchedule r, Iterator<CifRecord> records) {
////    Schedule schedule = new Schedule(null, null, null);
////    Route route = new Route(null, null, null);
////
////    for (int i = index; i < records.size(); i++) {
////      var curr = records.get(i);
////
////      switch (curr) {
////        case BasicSchedule r -> schedule = schedule.withBasicSchedule(r);
////        case BasicScheduleExtended r -> schedule = schedule.withBasicScheduleExtended(r);
////        case OriginLocation r -> route = route.withOriginLocation(r);
////        case IntermediateLocation r -> route.addNonTerminalPoint(r);
////        case ChangeEnRoute r -> route.addNonTerminalPoint(r);
////        case TerminatingLocation r -> {
////          route = route.withTerminatingLocation(r);
////          return schedule.withRoute(route);
////        }
////        default -> throw new IllegalStateException("Unexpected value: " + curr);
////      }
////    }
////
////
////  }
//
////  private static Route handleLocationRecord(Route workingRoute, LocationRecord locationRecord) {
////    if (workingRoute == null) {
////      workingRoute = new Route(null, new ArrayList<>(), null);
////    }
////
////    switch (locationRecord) {
////      case OriginLocation r -> workingRoute = workingRoute.withOriginLocation(r);
////      case ChangeEnRoute r -> workingRoute.nonTerminalPoints().add(r);
////      case IntermediateLocation r -> workingRoute.nonTerminalPoints().add(r);
////      case TerminatingLocation r -> workingRoute = workingRoute.withTerminatingLocation(r);
////    }
////
////    return workingRoute;
////  }
////
//
////  private enum MapKey {
////    HEADER,
////    SCHEDULE,
////    ASSOCIATION,
////    TIPLOC,
////    TRAILER;
////
////    public static <T extends CifRecord> MapKey mapThing(T asdf) {
////      return switch (asdf) {
////        case Association ignored -> ASSOCIATION;
////        case BasicSchedule ignored -> SCHEDULE;
////        case Header ignored -> HEADER;
////        case LocationRecord ignored -> TIPLOC;
////        case TiplocRecord ignored -> TIPLOC;
////        case Trailer ignored -> TRAILER;
////        default -> throw new IllegalStateException("Unexpected value: " + asdf);
////      };
////    }
////  }
//}
