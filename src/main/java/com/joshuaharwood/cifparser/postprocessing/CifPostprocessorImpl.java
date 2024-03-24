package com.joshuaharwood.cifparser.postprocessing;

import com.joshuaharwood.cifparser.parsing.lines.model.Association;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicScheduleExtended;
import com.joshuaharwood.cifparser.parsing.lines.model.ChangeEnRoute;
import com.joshuaharwood.cifparser.parsing.lines.model.CifRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.IntermediateLocation;
import com.joshuaharwood.cifparser.parsing.lines.model.LocationRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.OriginLocation;
import com.joshuaharwood.cifparser.parsing.lines.model.TerminatingLocation;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.Trailer;
import com.joshuaharwood.cifparser.postprocessing.Schedule.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public class CifPostprocessorImpl {

  private CifPostprocessorImpl() {
  }

  private static Schedule initialiseWorkingSchedule(@Nullable Schedule workingSchedule) {
    return Objects.requireNonNullElseGet(workingSchedule, () -> new Schedule(null, null, null));
  }

  public static CifPostprocessedResult postprocess(List<CifRecord> cifRecords) {
    Schedule workingSchedule = null;
    CifPostprocessedResult result = new CifPostprocessedResult(null, null, null, null, null);

    for (CifRecord cifRecord : cifRecords) {
      var x = switch (cifRecord) {
        case Header r -> result.withHeader(r);
        case Association r -> result.addAssociation(r);
        case BasicSchedule r -> handleSchedule(r, workingSchedule);
        case BasicScheduleExtended r -> handleSchedule(r, workingSchedule);
        case LocationRecord r -> handleSchedule(r, workingSchedule);
        case TiplocRecord tiplocRecord -> result.addTiplocRecord(tiplocRecord);
        case Trailer r -> result.withTrailer(r);
      };
    }

    return result;
  }

  private static Object handleSchedule(CifRecord r, Schedule workingSchedule) {
    return switch (r) {
      case BasicSchedule basicSchedule -> null;
      case BasicScheduleExtended basicScheduleExtended -> null;
      case Header header -> null;
      case LocationRecord locationRecord -> null;
      default -> throw new IllegalStateException("Unexpected record type: " + r);
    };
  }

  private static Route handleLocationRecord(Route workingRoute, LocationRecord locationRecord) {
    if (workingRoute == null) {
      workingRoute = new Route(null, new ArrayList<>(), null);
    }

    switch (locationRecord) {
      case OriginLocation r -> workingRoute = workingRoute.withOriginLocation(r);
      case ChangeEnRoute r -> workingRoute.nonTerminalPoints().add(r);
      case IntermediateLocation r -> workingRoute.nonTerminalPoints().add(r);
      case TerminatingLocation r -> workingRoute = workingRoute.withTerminatingLocation(r);
    }

    return workingRoute;
  }
}
