package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.BankHolidayRunning;
import com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public class BasicScheduleBuilder {

  private TransactionType transactionType;
  private String trainUid;
  private LocalDate dateRunsFrom;
  private @Nullable LocalDate dateRunsTo;
  private Set<DayOfWeek> daysRun;
  private BankHolidayRunning bankHolidayRunning;
  private TrainStatus trainStatus;
  private TrainCategory trainCategory;
  private String trainIdentity;
  private String headcode;
  private Byte courseIndicator;
  private Integer trainServiceCode;
  private Character portionId;
  private PowerType powerType;
  private String timingLoad;
  private Integer speed;
  private Set<OperatingCharacteristics> operatingCharacteristics;
  private SeatingClass seatingClass;
  private Sleepers sleepers;
  private Reservations reservations;
  private Character connectionIndicator;
  private Set<CateringCode> cateringCode;
  private String serviceBranding;
  private StpIndicator stpIndicator;
  private @Nullable String spare;

  public BasicScheduleBuilder setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public BasicScheduleBuilder setTrainUid(String trainUid) {
    this.trainUid = trainUid;
    return this;
  }

  public BasicScheduleBuilder setDateRunsFrom(LocalDate dateRunsFrom) {
    this.dateRunsFrom = dateRunsFrom;
    return this;
  }

  public BasicScheduleBuilder setDateRunsTo(@Nullable LocalDate dateRunsTo) {
    this.dateRunsTo = dateRunsTo;
    return this;
  }

  public BasicScheduleBuilder setDaysRun(Set<DayOfWeek> daysRun) {
    this.daysRun = daysRun;
    return this;
  }

  public BasicScheduleBuilder setBankHolidayRunning(BankHolidayRunning bankHolidayRunning) {
    this.bankHolidayRunning = bankHolidayRunning;
    return this;
  }

  public BasicScheduleBuilder setTrainStatus(TrainStatus trainStatus) {
    this.trainStatus = trainStatus;
    return this;
  }

  public BasicScheduleBuilder setTrainCategory(TrainCategory trainCategory) {
    this.trainCategory = trainCategory;
    return this;
  }

  public BasicScheduleBuilder setTrainIdentity(String trainIdentity) {
    this.trainIdentity = trainIdentity;
    return this;
  }

  public BasicScheduleBuilder setHeadcode(String headcode) {
    this.headcode = headcode;
    return this;
  }

  public BasicScheduleBuilder setCourseIndicator(Byte courseIndicator) {
    this.courseIndicator = courseIndicator;
    return this;
  }

  public BasicScheduleBuilder setTrainServiceCode(Integer trainServiceCode) {
    this.trainServiceCode = trainServiceCode;
    return this;
  }

  public BasicScheduleBuilder setPortionId(Character portionId) {
    this.portionId = portionId;
    return this;
  }

  public BasicScheduleBuilder setPowerType(PowerType powerType) {
    this.powerType = powerType;
    return this;
  }

  public BasicScheduleBuilder setTimingLoad(String timingLoad) {
    this.timingLoad = timingLoad;
    return this;
  }

  public BasicScheduleBuilder setSpeed(Integer speed) {
    this.speed = speed;
    return this;
  }

  public BasicScheduleBuilder setOperatingCharacteristics(Set<OperatingCharacteristics> operatingCharacteristics) {
    this.operatingCharacteristics = operatingCharacteristics;
    return this;
  }

  public BasicScheduleBuilder setSeatingClass(SeatingClass seatingClass) {
    this.seatingClass = seatingClass;
    return this;
  }

  public BasicScheduleBuilder setSleepers(Sleepers sleepers) {
    this.sleepers = sleepers;
    return this;
  }

  public BasicScheduleBuilder setReservations(Reservations reservations) {
    this.reservations = reservations;
    return this;
  }

  public BasicScheduleBuilder setConnectionIndicator(Character connectionIndicator) {
    this.connectionIndicator = connectionIndicator;
    return this;
  }

  public BasicScheduleBuilder setCateringCode(Set<CateringCode> cateringCode) {
    this.cateringCode = cateringCode;
    return this;
  }

  public BasicScheduleBuilder setServiceBranding(String serviceBranding) {
    this.serviceBranding = serviceBranding;
    return this;
  }

  public BasicScheduleBuilder setStpIndicator(StpIndicator stpIndicator) {
    this.stpIndicator = stpIndicator;
    return this;
  }

  public BasicScheduleBuilder setSpare(@Nullable String spare) {
    this.spare = spare;
    return this;
  }

  public BasicSchedule createBasicSchedule() {
    return new BasicSchedule(transactionType,
      trainUid,
      dateRunsFrom,
      dateRunsTo,
      daysRun,
      bankHolidayRunning,
      trainStatus,
      trainCategory,
      trainIdentity,
      headcode,
      courseIndicator,
      trainServiceCode,
      portionId,
      powerType,
      timingLoad,
      speed,
      operatingCharacteristics,
      seatingClass,
      sleepers,
      reservations,
      connectionIndicator,
      cateringCode,
      serviceBranding,
      stpIndicator,
      spare);
  }
}