package com.joshuaharwood.cifparser.parsing.model;

import com.joshuaharwood.cifparser.parsing.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.model.enums.ServiceBranding;
import com.joshuaharwood.cifparser.parsing.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.model.fielddefinitions.ChangeEnRouteFields;

//TODO: Some of these strings should be enums...
public record ChangeEnRouteRecord(String location, String trainCategory, String trainIdentity,
                                  String headcode, String courseIndicator,
                                  String profitCentreCodeTrainServiceCode, String businessSector,
                                  PowerType powerType, String timingLoad, int speed,
                                  OperatingCharacteristics operatingCharacteristics,
                                  String trainClass, Sleepers sleepers, Reservations reservations,
                                  String connectIndicator, CateringCode cateringCode,
                                  ServiceBranding serviceBranding, String tractionClass,
                                  String uicCode, String retailServiceId, String spare) implements
    LocationRecord<ChangeEnRouteFields> {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.CHANGE_EN_ROUTE;
  }

}
