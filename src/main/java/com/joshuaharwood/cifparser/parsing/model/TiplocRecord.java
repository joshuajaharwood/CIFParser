package com.joshuaharwood.cifparser.parsing.model;

public sealed interface TiplocRecord extends CIFRecord permits
    TiplocAmend, TiplocDelete, TiplocInsert {

  String tiploc();
}
