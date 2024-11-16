package com.joshuaharwood.cifparser.parsing.lines.model;

public sealed interface TiplocRecord extends CifRecord permits
    TiplocAmend, TiplocDelete, TiplocInsert {

  String tiplocCode();
}
