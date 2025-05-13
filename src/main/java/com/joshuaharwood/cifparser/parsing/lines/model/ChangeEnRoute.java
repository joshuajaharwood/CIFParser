package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public record ChangeEnRoute(String location,
                            TrainCategory trainCategory,
                            String trainIdentity,
                            @Nullable String headcode,
                            Byte courseIndicator,
                            String profitCentreCodeTrainServiceCode,
                            @Nullable String businessSector,
                            PowerType powerType,
                            String timingLoad,
                            Integer speed,
                            Set<OperatingCharacteristics> operatingCharacteristics,
                            SeatingClass trainClass,
                            @Nullable Sleepers sleepers,
                            @Nullable Reservations reservations,
                            @Nullable String connectIndicator,
                            @Nullable CateringCode cateringCode,
                            @Nullable String serviceBranding,
                            @Nullable String tractionClass,
                            @Nullable String uicCode,
                            @Nullable String retailServiceId,
                            @Nullable String spare) implements LocationRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.CHANGE_EN_ROUTE;
  }

}
