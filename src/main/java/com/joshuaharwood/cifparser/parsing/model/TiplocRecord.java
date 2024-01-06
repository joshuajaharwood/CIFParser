package com.joshuaharwood.cifparser.parsing.model;

public sealed interface TiplocRecord extends CifRecord permits
    TiplocAmend, TiplocDelete, TiplocInsert {

  String tiploc();
}
