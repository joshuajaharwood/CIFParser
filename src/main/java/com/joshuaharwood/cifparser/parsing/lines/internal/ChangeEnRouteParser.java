package com.joshuaharwood.cifparser.parsing.lines.internal;

import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.RowField;
import com.joshuaharwood.cifparser.parsing.lines.internal.fielddefinitions.location.changeenroute.ChangeEnRouteField.Instances;
import com.joshuaharwood.cifparser.parsing.lines.model.ChangeEnRoute;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public final class ChangeEnRouteParser implements RecordSpecificParser<ChangeEnRoute> {

  private final ChangeEnRouteRowDefinition fieldDefinitions;

  public ChangeEnRouteParser() {
    this(ChangeEnRouteRowDefinition.DEFAULT_ROW_DEFINITION);
  }

  public ChangeEnRouteParser(ChangeEnRouteRowDefinition fieldDefinitions) {
    this.fieldDefinitions = fieldDefinitions;
  }

  @Override
  public ChangeEnRoute parse(String record) {
    return new ChangeEnRoute(fieldDefinitions.location().substringAndConvert(record),
      fieldDefinitions.trainCategory().substringAndConvert(record),
      fieldDefinitions.trainIdentity().substringAndConvert(record),
      fieldDefinitions.headcode().substringAndConvert(record),
      fieldDefinitions.courseIndicator().substringAndConvert(record),
      fieldDefinitions.profitCentreCodeTrainServiceCode().substringAndConvert(record),
      fieldDefinitions.businessSector().substringAndConvert(record),
      fieldDefinitions.powerType().substringAndConvert(record),
      fieldDefinitions.timingLoad().substringAndConvert(record),
      fieldDefinitions.speed().substringAndConvert(record),
      fieldDefinitions.operatingCharacteristics().substringAndConvert(record),
      fieldDefinitions.trainClass().substringAndConvert(record),
      fieldDefinitions.sleepers().substringAndConvert(record),
      fieldDefinitions.reservations().substringAndConvert(record),
      fieldDefinitions.connectIndicator().substringAndConvert(record),
      fieldDefinitions.cateringCode().substringAndConvert(record),
      fieldDefinitions.serviceBranding().substringAndConvert(record),
      fieldDefinitions.tractionClass().substringAndConvert(record),
      fieldDefinitions.uicCode().substringAndConvert(record),
      fieldDefinitions.retailServiceId().substringAndConvert(record),
      fieldDefinitions.spare().substringAndConvert(record)
    );
  }

  public record ChangeEnRouteRowDefinition(RowField<String> location,
                                           RowField<TrainCategory> trainCategory,
                                           RowField<String> trainIdentity,
                                           RowField<String> headcode,
                                           RowField<Byte> courseIndicator,
                                           RowField<String> profitCentreCodeTrainServiceCode,
                                           RowField<String> businessSector,
                                           RowField<PowerType> powerType,
                                           RowField<String> timingLoad, RowField<Integer> speed,
                                           RowField<Set<OperatingCharacteristics>> operatingCharacteristics,
                                           RowField<SeatingClass> trainClass,
                                           RowField<Sleepers> sleepers,
                                           RowField<Reservations> reservations,
                                           RowField<String> connectIndicator,
                                           RowField<CateringCode> cateringCode,
                                           RowField<String> serviceBranding,
                                           RowField<String> tractionClass, RowField<String> uicCode,
                                           RowField<String> retailServiceId,
                                           RowField<@Nullable String> spare) {

    public static final ChangeEnRouteRowDefinition DEFAULT_ROW_DEFINITION = new ChangeEnRouteRowDefinition(
      Instances.LOCATION,
      Instances.TRAIN_CATEGORY,
      Instances.TRAIN_IDENTITY,
      Instances.HEADCODE,
      Instances.COURSE_INDICATOR,
      Instances.PROFIT_CENTRE_CODE_TRAIN_SERVICE_CODE,
      Instances.BUSINESS_SECTOR,
      Instances.POWER_TYPE,
      Instances.TIMING_LOAD,
      Instances.SPEED,
      Instances.OPERATING_CHARACTERISTICS,
      Instances.TRAIN_CLASS,
      Instances.SLEEPERS,
      Instances.RESERVATIONS,
      Instances.CONNECT_INDICATOR,
      Instances.CATERING_CODE,
      Instances.SERVICE_BRANDING,
      Instances.TRACTION_CLASS,
      Instances.UIC_CODE,
      Instances.RETAIL_SERVICE_ID,
      Instances.SPARE);
  }
}
