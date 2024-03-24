package com.joshuaharwood.cifparser.postprocessing;

import com.joshuaharwood.cifparser.parsing.lines.model.Association;
import com.joshuaharwood.cifparser.parsing.lines.model.Header;
import com.joshuaharwood.cifparser.parsing.lines.model.TiplocRecord;
import com.joshuaharwood.cifparser.parsing.lines.model.Trailer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record CifPostprocessedResult(Header header, List<TiplocRecord> tiplocRecords,
                                     List<Schedule> schedules, List<Association> associations,
                                     Trailer trailer) {

  private static <T> @NotNull List<T> addElement(@Nullable List<T> list, T element) {
    List<T> listRef = Objects.requireNonNullElseGet(list, ArrayList::new);

    listRef.add(element);

    return listRef;
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult withHeader(Header header) {
    return new CifPostprocessedResult(header, tiplocRecords, schedules, associations, trailer);
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult withTiplocRecords(List<TiplocRecord> tiplocRecords) {
    return new CifPostprocessedResult(header, tiplocRecords, schedules, associations, trailer);
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult addTiplocRecord(TiplocRecord tiplocRecord) {
    return new CifPostprocessedResult(header,
      addElement(tiplocRecords, tiplocRecord),
      schedules,
      associations,
      trailer);
  }

  public @NotNull CifPostprocessedResult withSchedules(List<Schedule> schedules) {
    return new CifPostprocessedResult(header, tiplocRecords, schedules, associations, trailer);
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult addSchedule(@NotNull Schedule schedule) {
    return new CifPostprocessedResult(header,
      tiplocRecords,
      addElement(schedules, schedule),
      associations,
      trailer);
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult addAssociation(Association association) {
    return new CifPostprocessedResult(header,
      tiplocRecords,
      schedules,
      addElement(associations, association),
      trailer);
  }

  public @NotNull CifPostprocessedResult withAssociations(List<Association> associations) {
    return new CifPostprocessedResult(header, tiplocRecords, schedules, associations, trailer);
  }

  @Contract("_ -> new")
  public @NotNull CifPostprocessedResult withTrailer(Trailer trailer) {
    return new CifPostprocessedResult(header, tiplocRecords, schedules, associations, trailer);
  }
}
