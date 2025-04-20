package com.joshuaharwood.cifparser.parsing.lines.model;

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
import com.joshuaharwood.cifparser.parsing.lines.model.enums.TrainStatus;
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

}