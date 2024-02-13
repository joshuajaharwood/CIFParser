package com.joshuaharwood.cifparser.parsing.lines.internal.model;

public sealed interface TiplocRecord extends CifRecord permits
    TiplocAmend, TiplocDelete, TiplocInsert {

  String tiploc();
}
