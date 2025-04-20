package com.joshuaharwood.cifparser.parsing.lines.model;

import static com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.SHORT_TERM_PLANNING;
import static com.joshuaharwood.cifparser.parsing.lines.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.WORKING_TIMETABLE;

import com.joshuaharwood.cifparser.parsing.lines.internal.literals.Literal;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
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