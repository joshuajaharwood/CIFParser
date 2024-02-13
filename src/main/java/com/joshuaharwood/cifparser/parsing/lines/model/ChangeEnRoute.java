package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.ChangeEnRouteFields;
import java.util.Set;

public record ChangeEnRoute(String location,
                            TrainCategory trainCategory,
                            String trainIdentity,
                            String headcode,
                            Byte courseIndicator,
                            String profitCentreCodeTrainServiceCode,
                            String businessSector,
                            PowerType powerType,
                            String timingLoad,
                            Integer speed,
                            Set<OperatingCharacteristics> operatingCharacteristics,
                            SeatingClass trainClass,
                            Sleepers sleepers,
                            Reservations reservations,
                            String connectIndicator,
                            CateringCode cateringCode,
                            String serviceBranding,
                            String tractionClass,
                            String uicCode,
                            String retailServiceId,
                            String spare) implements LocationRecord<ChangeEnRouteFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.CHANGE_EN_ROUTE;
  }

}
