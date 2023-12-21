package com.joshuaharwood.cifparser.records.model.enums;

import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.BUSES_AND_SHIPS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.DEPARTMENTAL_TRAINS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.EMPTY_COACHING_STOCK_TRAINS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.EXPRESS_PASSENGER_TRAINS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.LIGHT_LOCOMOTIVES;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.ORDINARY_PASSENGER_TRAINS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.PARCELS_AND_POSTAL_TRAINS;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.RAILFREIGHT_DISTRIBUTION;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL;
import static com.joshuaharwood.cifparser.records.model.enums.TrainCategory.TrainCategoryDescription.TRAINLOAD_FREIGHT;

import com.joshuaharwood.cifparser.records.model.literals.Literal;

public enum TrainCategory implements Literal {
  LONDON_UNDERGROUND_METRO_SERVICE("OL",
      ORDINARY_PASSENGER_TRAINS,
      "London Underground/Metro Service"),
  UNADVERTISED_ORDINARY_PASSENGER("OU",
      ORDINARY_PASSENGER_TRAINS,
      "Unadvertised Ordinary Passenger"),
  ORDINARY_PASSENGER("OO", ORDINARY_PASSENGER_TRAINS, "Ordinary Passenger"),
  STAFF_TRAIN("OS", ORDINARY_PASSENGER_TRAINS, "Staff Train"),
  MIXED("OW", ORDINARY_PASSENGER_TRAINS, "Mixed"),
  CHANNEL_TUNNEL("XC", EXPRESS_PASSENGER_TRAINS, "Channel Tunnel"),
  SLEEPER_EUROPE_NIGHT_SERVICES("XD", EXPRESS_PASSENGER_TRAINS, "Sleeper (Europe Night Services)"),
  INTERNATIONAL("XI", EXPRESS_PASSENGER_TRAINS, "International"),
  MOTORAIL("XR", EXPRESS_PASSENGER_TRAINS, "Motorail"),
  UNADVERTISED_EXPRESS("XU", EXPRESS_PASSENGER_TRAINS, "Unadvertised Express"),
  EXPRESS_PASSENGER("XX", EXPRESS_PASSENGER_TRAINS, "Express Passenger"),
  SLEEPER_DOMESTIC("XZ", EXPRESS_PASSENGER_TRAINS, "Sleeper (Domestic)"),
  BUS_REPLACEMENT_DUE_TO_ENGINEERING_WORK("BR",
      BUSES_AND_SHIPS,
      "Bus – Replacement due to engineering work"),
  BUS_WTT_SERVICE("BS", BUSES_AND_SHIPS, "Bus – WTT Service"),
  SHIP("SS", BUSES_AND_SHIPS, "Ship"),
  EMPTY_COACHING_STOCK_ECS("EE", EMPTY_COACHING_STOCK_TRAINS, "Empty Coaching Stock (ECS)"),
  ECS_LONDON_UNDERGROUND_METRO_SERVICE("EL",
      EMPTY_COACHING_STOCK_TRAINS,
      "ECS, London Underground/Metro Service"),
  ECS_STAFF("ES", EMPTY_COACHING_STOCK_TRAINS, "ECS & Staff"),
  POSTAL("JJ", PARCELS_AND_POSTAL_TRAINS, "Postal"),
  POST_OFFICE_CONTROLLED_PARCELS("PM", PARCELS_AND_POSTAL_TRAINS, "Post Office Controlled Parcels"),
  PARCELS("PP", PARCELS_AND_POSTAL_TRAINS, "Parcels"),
  EMPTY_NPCCS("PV", PARCELS_AND_POSTAL_TRAINS, "Empty NPCCS"),
  DEPARTMENTAL("DD", DEPARTMENTAL_TRAINS, "Departmental"),
  CIVIL_ENGINEER("DH", DEPARTMENTAL_TRAINS, "Civil Engineer"),
  MECHANICAL_ELECTRICAL_ENGINEER("DI", DEPARTMENTAL_TRAINS, "Mechanical & Electrical Engineer"),
  STORES("DQ", DEPARTMENTAL_TRAINS, "Stores"),
  TEST("DT", DEPARTMENTAL_TRAINS, "Test"),
  SIGNAL_TELECOMMUNICATIONS_ENGINEER("DY",
      DEPARTMENTAL_TRAINS,
      "Signal & Telecommunications Engineer"),
  LOCOMOTIVE_BRAKE_VAN("ZB", LIGHT_LOCOMOTIVES, "Locomotive & Brake Van"),
  LIGHT_LOCOMOTIVE("ZZ", LIGHT_LOCOMOTIVES, "Light Locomotive"),
  RFD_AUTOMOTIVE_COMPONENTS("J2", RAILFREIGHT_DISTRIBUTION, "RfD Automotive (Components)"),
  RFD_AUTOMOTIVE_VEHICLES("H2", RAILFREIGHT_DISTRIBUTION, "RfD Automotive (Vehicles)"),
  RFD_EDIBLE_PRODUCTS_UK_CONTRACTS("J3",
      RAILFREIGHT_DISTRIBUTION,
      "RfD Edible Products (UK Contracts)"),
  RFD_INDUSTRIAL_MINERALS_UK_CONTRACTS("J4",
      RAILFREIGHT_DISTRIBUTION,
      "RfD Industrial Minerals (UK Contracts)"),
  RFD_CHEMICALS_UK_CONTRACTS("J5", RAILFREIGHT_DISTRIBUTION, "RfD Chemicals (UK Contracts)"),
  RFD_BUILDING_MATERIALS_UK_CONTRACTS("J6",
      RAILFREIGHT_DISTRIBUTION,
      "RfD Building Materials (UK Contracts)"),
  RFD_GENERAL_MERCHANDISE_UK_CONTRACTS("J8",
      RAILFREIGHT_DISTRIBUTION,
      "RfD General Merchandise (UK Contracts)"),
  RFD_EUROPEAN("H8", RAILFREIGHT_DISTRIBUTION, "RfD European"),
  RFD_FREIGHTLINER_CONTRACTS("J9", RAILFREIGHT_DISTRIBUTION, "RfD Freightliner (Contracts)"),
  RFD_FREIGHTLINER_OTHER("H9", RAILFREIGHT_DISTRIBUTION, "RfD Freightliner (Other)"),
  COAL_DISTRIBUTIVE("A0", TRAINLOAD_FREIGHT, "Coal (Distributive)"),
  COAL_ELECTRICITY_MGR("E0", TRAINLOAD_FREIGHT, "Coal (Electricity) MGR"),
  COAL_OTHER_AND_NUCLEAR("B0", TRAINLOAD_FREIGHT, "Coal (Other) and Nuclear"),
  METALS("B1", TRAINLOAD_FREIGHT, "Metals"),
  AGGREGATES("B4", TRAINLOAD_FREIGHT, "Aggregates"),
  DOMESTIC_AND_INDUSTRIAL_WASTE("B5", TRAINLOAD_FREIGHT, "Domestic and Industrial Waste"),
  BUILDING_MATERIALS_TLF("B6", TRAINLOAD_FREIGHT, "Building Materials (TLF)"),
  PETROLEUM_PRODUCTS("B7", TRAINLOAD_FREIGHT, "Petroleum Products"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_MIXED_BUSINESS("H0",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel (Mixed Business)"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_INTERMODAL("H1",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel Intermodal"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_AUTOMOTIVE("H3",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel Automotive"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_CONTRACT_SERVICES("H4",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel Contract Services"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_HAULMARK("H5",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel Haulmark"),
  RFD_EUROPEAN_CHANNEL_TUNNEL_JOINT_VENTURE("H6",
      RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL,
      "RfD European Channel Tunnel Joint Venture");

  private final String literal;
  private final TrainCategoryDescription trainCategoryDescription;
  private final String description;

  TrainCategory(String literal,
      TrainCategoryDescription trainCategoryDescription,
      String description) {
    this.literal = literal;
    this.trainCategoryDescription = trainCategoryDescription;
    this.description = description;
  }

  @Override
  public String getLiteral() {
    return literal;
  }

  public TrainCategoryDescription getTrainCategoryDescription() {
    return trainCategoryDescription;
  }

  public String getDescription() {
    return description;
  }

  public enum TrainCategoryDescription {
    ORDINARY_PASSENGER_TRAINS("Ordinary Passenger Trains"),
    EXPRESS_PASSENGER_TRAINS("Express Passenger Trains"),
    BUSES_AND_SHIPS("Buses & Ships"),
    EMPTY_COACHING_STOCK_TRAINS("Empty Coaching Stock Trains"),
    PARCELS_AND_POSTAL_TRAINS("Parcels and Postal Trains"),
    DEPARTMENTAL_TRAINS("Departmental Trains"),
    LIGHT_LOCOMOTIVES("Light Locomotives"),
    RAILFREIGHT_DISTRIBUTION("Railfreight Distribution"),
    TRAINLOAD_FREIGHT("Trainload Freight"),
    RAILFREIGHT_DISTRIBUTION_CHANNEL_TUNNEL("Railfreight Distribution (Channel Tunnel)");

    private final String description;

    TrainCategoryDescription(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
  }
}
