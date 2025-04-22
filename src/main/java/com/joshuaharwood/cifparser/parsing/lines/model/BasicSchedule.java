package com.joshuaharwood.cifparser.parsing.lines.model;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.BankHolidayRunning;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import org.jspecify.annotations.NullUnmarked;
import org.jspecify.annotations.Nullable;

public record BasicSchedule(
  TransactionType transactionType,
  String trainUid,
  LocalDate dateRunsFrom,
  LocalDate dateRunsTo,
  Set<DayOfWeek> daysRun,
  BankHolidayRunning bankHolidayRunning,
  TrainStatus trainStatus,
  TrainCategory trainCategory,
  String trainIdentity,
  @Nullable String headcode,
  Byte courseIndicator,
  Integer trainServiceCode,
  @Nullable Character portionId,
  PowerType powerType,
  @Nullable String timingLoad,
  Integer speed,
  Set<OperatingCharacteristics> operatingCharacteristics,
  @Nullable SeatingClass seatingClass,
  @Nullable Sleepers sleepers,
  @Nullable Reservations reservations,
  @Nullable Character connectionIndicator,
  Set<CateringCode> cateringCode,
  @Nullable String serviceBranding,
  @Nullable String spare, 
  StpIndicator stpIndicator
) implements CifRecord {

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE;
  }

  @NullUnmarked
  public static class Builder {
    private TransactionType transactionType;
    private String trainUid;
    private LocalDate dateRunsFrom;
    private LocalDate dateRunsTo;
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
    private String spare;
  
    public Builder setTransactionType(TransactionType transactionType) {
      this.transactionType = transactionType;
      return this;
    }
  
    public Builder setTrainUid(String trainUid) {
      this.trainUid = trainUid;
      return this;
    }
  
    public Builder setDateRunsFrom(LocalDate dateRunsFrom) {
      this.dateRunsFrom = dateRunsFrom;
      return this;
    }
  
    public Builder setDateRunsTo(LocalDate dateRunsTo) {
      this.dateRunsTo = dateRunsTo;
      return this;
    }
  
    public Builder setDaysRun(Set<DayOfWeek> daysRun) {
      this.daysRun = daysRun;
      return this;
    }
  
    public Builder setBankHolidayRunning(BankHolidayRunning bankHolidayRunning) {
      this.bankHolidayRunning = bankHolidayRunning;
      return this;
    }
  
    public Builder setTrainStatus(TrainStatus trainStatus) {
      this.trainStatus = trainStatus;
      return this;
    }
  
    public Builder setTrainCategory(TrainCategory trainCategory) {
      this.trainCategory = trainCategory;
      return this;
    }
  
    public Builder setTrainIdentity(String trainIdentity) {
      this.trainIdentity = trainIdentity;
      return this;
    }
  
    public Builder setHeadcode(String headcode) {
      this.headcode = headcode;
      return this;
    }
  
    public Builder setCourseIndicator(Byte courseIndicator) {
      this.courseIndicator = courseIndicator;
      return this;
    }
  
    public Builder setTrainServiceCode(Integer trainServiceCode) {
      this.trainServiceCode = trainServiceCode;
      return this;
    }
  
    public Builder setPortionId(Character portionId) {
      this.portionId = portionId;
      return this;
    }
  
    public Builder setPowerType(PowerType powerType) {
      this.powerType = powerType;
      return this;
    }
  
    public Builder setTimingLoad(String timingLoad) {
      this.timingLoad = timingLoad;
      return this;
    }
  
    public Builder setSpeed(Integer speed) {
      this.speed = speed;
      return this;
    }
  
    public Builder setOperatingCharacteristics(Set<OperatingCharacteristics> operatingCharacteristics) {
      this.operatingCharacteristics = operatingCharacteristics;
      return this;
    }
  
    public Builder setSeatingClass(SeatingClass seatingClass) {
      this.seatingClass = seatingClass;
      return this;
    }
  
    public Builder setSleepers(Sleepers sleepers) {
      this.sleepers = sleepers;
      return this;
    }
  
    public Builder setReservations(Reservations reservations) {
      this.reservations = reservations;
      return this;
    }
  
    public Builder setConnectionIndicator(Character connectionIndicator) {
      this.connectionIndicator = connectionIndicator;
      return this;
    }
  
    public Builder setCateringCode(Set<CateringCode> cateringCode) {
      this.cateringCode = cateringCode;
      return this;
    }
  
    public Builder setServiceBranding(String serviceBranding) {
      this.serviceBranding = serviceBranding;
      return this;
    }
  
    public Builder setStpIndicator(StpIndicator stpIndicator) {
      this.stpIndicator = stpIndicator;
      return this;
    }
  
    public Builder setSpare(String spare) {
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
        spare, stpIndicator
      );
    }
  }
}