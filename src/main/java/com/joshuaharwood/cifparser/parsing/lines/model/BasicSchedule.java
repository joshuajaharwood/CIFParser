package com.joshuaharwood.cifparser.parsing.lines.model;

import static com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.SHORT_TERM_PLANNING;
import static com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.WORKING_TIMETABLE;

import com.joshuaharwood.cifparser.parsing.lines.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.StpIndicator;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TransactionType;
import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import org.jspecify.annotations.Nullable;

public final class BasicSchedule implements CifRecord {

  private final TransactionType transactionType;
  private final String trainUid;
  private final LocalDate dateRunsFrom;
  private final @Nullable LocalDate dateRunsTo;
  private final Set<DayOfWeek> daysRun;
  private final BankHolidayRunning bankHolidayRunning;
  private final TrainStatus trainStatus;
  private final TrainCategory trainCategory;
  private final String trainIdentity;
  private final String headcode;
  private final Byte courseIndicator;
  private final Integer trainServiceCode;
  private final Character portionId;
  private final PowerType powerType;
  private final String timingLoad;
  private final Integer speed;
  private final Set<OperatingCharacteristics> operatingCharacteristics;
  private final SeatingClass seatingClass;
  private final Sleepers sleepers;
  private final Reservations reservations;
  private final Character connectionIndicator;
  private final Set<CateringCode> cateringCode;
  private final String serviceBranding;
  private final StpIndicator stpIndicator;
  private final @Nullable String spare;

  public BasicSchedule(
    TransactionType transactionType,
    String trainUid,
    LocalDate dateRunsFrom,
    @Nullable LocalDate dateRunsTo,
    Set<DayOfWeek> daysRun,
    BankHolidayRunning bankHolidayRunning,
    TrainStatus trainStatus,
    TrainCategory trainCategory,
    String trainIdentity,
    String headcode,
    Byte courseIndicator,
    Integer trainServiceCode,
    Character portionId,
    PowerType powerType,
    String timingLoad,
    Integer speed,
    Set<OperatingCharacteristics> operatingCharacteristics,
    SeatingClass seatingClass,
    Sleepers sleepers,
    Reservations reservations,
    Character connectionIndicator,
    Set<CateringCode> cateringCode,
    String serviceBranding,
    StpIndicator stpIndicator,
    @Nullable String spare
  ) {
    this.transactionType = transactionType;
    this.trainUid = trainUid;
    this.dateRunsFrom = dateRunsFrom;
    this.dateRunsTo = dateRunsTo;
    this.daysRun = daysRun;
    this.bankHolidayRunning = bankHolidayRunning;
    this.trainStatus = trainStatus;
    this.trainCategory = trainCategory;
    this.trainIdentity = trainIdentity;
    this.headcode = headcode;
    this.courseIndicator = courseIndicator;
    this.trainServiceCode = trainServiceCode;
    this.portionId = portionId;
    this.powerType = powerType;
    this.timingLoad = timingLoad;
    this.speed = speed;
    this.operatingCharacteristics = operatingCharacteristics;
    this.seatingClass = seatingClass;
    this.sleepers = sleepers;
    this.reservations = reservations;
    this.connectionIndicator = connectionIndicator;
    this.cateringCode = cateringCode;
    this.serviceBranding = serviceBranding;
    this.stpIndicator = stpIndicator;
    this.spare = spare;
  }

  @Override
  public RecordIdentity recordIdentity() {
    return RecordIdentity.BASIC_SCHEDULE;
  }

  public TransactionType transactionType() {
    return transactionType;
  }

  public String trainUid() {
    return trainUid;
  }

  public LocalDate dateRunsFrom() {
    return dateRunsFrom;
  }

  public @Nullable LocalDate dateRunsTo() {
    return dateRunsTo;
  }

  public Set<DayOfWeek> daysRun() {
    return daysRun;
  }

  public BankHolidayRunning bankHolidayRunning() {
    return bankHolidayRunning;
  }

  public TrainStatus trainStatus() {
    return trainStatus;
  }

  public TrainCategory trainCategory() {
    return trainCategory;
  }

  public String trainIdentity() {
    return trainIdentity;
  }

  public String headcode() {
    return headcode;
  }

  public Byte courseIndicator() {
    return courseIndicator;
  }

  public Integer trainServiceCode() {
    return trainServiceCode;
  }

  public Character portionId() {
    return portionId;
  }

  public PowerType powerType() {
    return powerType;
  }

  public String timingLoad() {
    return timingLoad;
  }

  public Integer speed() {
    return speed;
  }

  public Set<OperatingCharacteristics> operatingCharacteristics() {
    return operatingCharacteristics;
  }

  public SeatingClass seatingClass() {
    return seatingClass;
  }

  public Sleepers sleepers() {
    return sleepers;
  }

  public Reservations reservations() {
    return reservations;
  }

  public Character connectionIndicator() {
    return connectionIndicator;
  }

  public Set<CateringCode> cateringCode() {
    return cateringCode;
  }

  public String serviceBranding() {
    return serviceBranding;
  }

  public StpIndicator stpIndicator() {
    return stpIndicator;
  }

  public @Nullable String spare() {
    return spare;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (BasicSchedule) obj;
    return Objects.equals(this.transactionType, that.transactionType) &&
           Objects.equals(this.trainUid, that.trainUid) &&
           Objects.equals(this.dateRunsFrom, that.dateRunsFrom) &&
           Objects.equals(this.dateRunsTo, that.dateRunsTo) &&
           Objects.equals(this.daysRun, that.daysRun) &&
           Objects.equals(this.bankHolidayRunning, that.bankHolidayRunning) &&
           Objects.equals(this.trainStatus, that.trainStatus) &&
           Objects.equals(this.trainCategory, that.trainCategory) &&
           Objects.equals(this.trainIdentity, that.trainIdentity) &&
           Objects.equals(this.headcode, that.headcode) &&
           Objects.equals(this.courseIndicator, that.courseIndicator) &&
           Objects.equals(this.trainServiceCode, that.trainServiceCode) &&
           Objects.equals(this.portionId, that.portionId) &&
           Objects.equals(this.powerType, that.powerType) &&
           Objects.equals(this.timingLoad, that.timingLoad) &&
           Objects.equals(this.speed, that.speed) &&
           Objects.equals(this.operatingCharacteristics, that.operatingCharacteristics) &&
           Objects.equals(this.seatingClass, that.seatingClass) &&
           Objects.equals(this.sleepers, that.sleepers) &&
           Objects.equals(this.reservations, that.reservations) &&
           Objects.equals(this.connectionIndicator, that.connectionIndicator) &&
           Objects.equals(this.cateringCode, that.cateringCode) &&
           Objects.equals(this.serviceBranding, that.serviceBranding) &&
           Objects.equals(this.stpIndicator, that.stpIndicator) &&
           Objects.equals(this.spare, that.spare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionType,
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

  @Override
  public String toString() {
    return "BasicSchedule[" +
           "transactionType=" + transactionType + ", " +
           "trainUid=" + trainUid + ", " +
           "dateRunsFrom=" + dateRunsFrom + ", " +
           "dateRunsTo=" + dateRunsTo + ", " +
           "daysRun=" + daysRun + ", " +
           "bankHolidayRunning=" + bankHolidayRunning + ", " +
           "trainStatus=" + trainStatus + ", " +
           "trainCategory=" + trainCategory + ", " +
           "trainIdentity=" + trainIdentity + ", " +
           "headcode=" + headcode + ", " +
           "courseIndicator=" + courseIndicator + ", " +
           "trainServiceCode=" + trainServiceCode + ", " +
           "portionId=" + portionId + ", " +
           "powerType=" + powerType + ", " +
           "timingLoad=" + timingLoad + ", " +
           "speed=" + speed + ", " +
           "operatingCharacteristics=" + operatingCharacteristics + ", " +
           "seatingClass=" + seatingClass + ", " +
           "sleepers=" + sleepers + ", " +
           "reservations=" + reservations + ", " +
           "connectionIndicator=" + connectionIndicator + ", " +
           "cateringCode=" + cateringCode + ", " +
           "serviceBranding=" + serviceBranding + ", " +
           "stpIndicator=" + stpIndicator + ", " +
           "spare=" + spare + ']';
  }


  public enum BankHolidayRunning implements Literal {
    NOT_ON_SPECIFIED_BANK_HOLIDAY_MONDAYS("X"),
    NOT_ON_GLASGOW_BANK_HOLIDAY("G");

    private final String literal;

    BankHolidayRunning(String literal) {
      this.literal = literal;
    }

    @Override
    public String getLiteral() {
      return literal;
    }
  }

  public enum TrainStatus implements Literal {
    BUS_PERMANENT("B", null),
    FREIGHT_PERMANENT("F", WORKING_TIMETABLE),
    PASSENGER_AND_PARCELS_PERMANENT("P", WORKING_TIMETABLE),
    SHIP_PERMANENT("S", null),
    TRIP_PERMANENT("T", null),
    PASSENGER_AND_PARCELS("1", SHORT_TERM_PLANNING),
    FREIGHT("2", SHORT_TERM_PLANNING),
    TRIP("3", SHORT_TERM_PLANNING),
    SHIP("4", SHORT_TERM_PLANNING),
    BUS("5", SHORT_TERM_PLANNING);

    @Nullable
    private final TrainStatusSchedulingType schedulingType;
    private final String literal;

    TrainStatus(String literal, @Nullable TrainStatusSchedulingType schedulingType) {
      this.literal = literal;
      this.schedulingType = schedulingType;
    }

    @Override
    public String getLiteral() {
      return literal;
    }

    @SuppressWarnings("unused")
    public @Nullable TrainStatusSchedulingType getSchedulingType() {
      return schedulingType;
    }

    public enum TrainStatusSchedulingType {
      SHORT_TERM_PLANNING("STP"),
      WORKING_TIMETABLE("WTT");

      private final String acronym;

      TrainStatusSchedulingType(String acronym) {
        this.acronym = acronym;
      }

      @SuppressWarnings("unused")

      public String getAcronym() {
        return acronym;
      }
    }
  }
}