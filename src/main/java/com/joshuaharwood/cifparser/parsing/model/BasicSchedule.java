package com.joshuaharwood.cifparser.parsing.model;

import static com.joshuaharwood.cifparser.parsing.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.SHORT_TERM_PLANNING;
import static com.joshuaharwood.cifparser.parsing.model.BasicSchedule.TrainStatus.TrainStatusSchedulingType.WORKING_TIMETABLE;

import com.joshuaharwood.cifparser.parsing.model.enums.CateringCode;
import com.joshuaharwood.cifparser.parsing.model.enums.OperatingCharacteristics;
import com.joshuaharwood.cifparser.parsing.model.enums.PowerType;
import com.joshuaharwood.cifparser.parsing.model.enums.RecordIdentity;
import com.joshuaharwood.cifparser.parsing.model.enums.Reservations;
import com.joshuaharwood.cifparser.parsing.model.enums.STPIndicator;
import com.joshuaharwood.cifparser.parsing.model.enums.SeatingClass;
import com.joshuaharwood.cifparser.parsing.model.enums.ServiceBranding;
import com.joshuaharwood.cifparser.parsing.model.enums.Sleepers;
import com.joshuaharwood.cifparser.parsing.model.enums.TrainCategory;
import com.joshuaharwood.cifparser.parsing.model.enums.TransactionType;
import com.joshuaharwood.cifparser.parsing.model.literals.Literal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public record BasicSchedule(String spare, TransactionType transactionType, String trainUid,
                            LocalDate dateRunsFrom, LocalDate dateRunsTo,
                            Map<DayOfWeek, Boolean> daysRun, BankHolidayRunning bankHolidayRunning,
                            TrainStatus trainStatus, TrainCategory trainCategory,
                            String trainIdentity, int headcode, byte courseIndicator,
                            int trainServiceCode, char portionId, PowerType powerType,
                            String timingLoad, int speed,
                            Set<OperatingCharacteristics> operatingCharacteristics,
                            SeatingClass seatingClass, Sleepers sleepers, Reservations reservations,
                            Character connectionIndicator, CateringCode cateringCode,
                            ServiceBranding serviceBranding, STPIndicator stpIndicator) implements
    CIFRecord {

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

    private final TrainStatusSchedulingType schedulingType;
    private final String literal;

    TrainStatus(String literal, TrainStatusSchedulingType schedulingType) {
      this.literal = literal;
      this.schedulingType = schedulingType;
    }

    @Override
    public String getLiteral() {
      return literal;
    }

    public TrainStatusSchedulingType getSchedulingType() {
      return schedulingType;
    }

    public enum TrainStatusSchedulingType {
      SHORT_TERM_PLANNING("STP"),
      WORKING_TIMETABLE("WTT");

      private final String acronym;

      TrainStatusSchedulingType(String acronym) {
        this.acronym = acronym;
      }

      public String getAcronym() {
        return acronym;
      }
    }
  }
}
