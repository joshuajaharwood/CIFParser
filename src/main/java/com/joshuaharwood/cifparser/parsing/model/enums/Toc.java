package com.joshuaharwood.cifparser.parsing.model.enums;

import com.joshuaharwood.cifparser.parsing.model.literals.Literal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")
public enum Toc implements Literal {
  VIRTUAL_EUROPEAN_PATHS("EU", "Virtual European Paths", null, "EU", true, false),
  ALLIANCE_RAIL("ZB", "Alliance Rail", "14", "AR", true, false),
  NORTHERN_TRAINS("ED", "Northern Trains", "23", "NT", true, false),
  TRANSPORT_FOR_WALES("HL", "Transport for Wales", "71", "AW", true, false),
  C2C("HT", "c2c", "79", "CC", true, false),
  CALEDONIAN_SLEEPER("ES", "Caledonian Sleeper", "35", "CS", true, false),
  CHILTERN_RAILWAYS("HO", "Chiltern Railways", "74", "CH", true, false),
  CROSS_COUNTRY("EH", "CrossCountry", "27", "XC", true, false),
  DC_RAIL("PO", "DC Rail", "34", "ZZ", true, false),
  EAST_MIDLANDS_RAILWAY("EM", "East Midlands Railway", "28", "EM", true, false),
  EUROSTAR("GA", "Eurostar", "06", "ES", true, false),
  UNMAPPED_FIRST_CAPITAL_CONNECT("EG",
      "Unmapped (was First Capital Connect)",
      "26",
      "FC",
      false,
      false),
  HULL_TRAINS("PF", "Hull Trains", "55", "HT", true, false),
  UNMAPPED_GATWICK_EXPRESS("HV", "Unmapped (was Gatwick Express)", "81", "GX", false, false),
  GB_RAILFREIGHT("PE", "GB Railfreight", "54", "ZZ", true, false),
  GOVIA_THAMESLINK_GREAT_NORTHERN("ET",
      "Govia Thameslink Railway (Great Northern)",
      "88",
      "GN",
      true,
      false),
  GOVIA_THAMESLINK_THAMESLINK("ET",
      "Govia Thameslink Railway (Thameslink)",
      "88",
      "TL",
      true,
      false),
  GRAND_CENTRAL("EC", "Grand Central", "22", "GC", true, false),
  GRAND_CENTRAL_NORTH_WEST("LN", "Grand Central (North West)", "14", "GC[2]", true, false),
  GREAT_WESTERN_RAILWAY("EF", "Great Western Railway", "25", "GW", true, false),
  GREATER_ANGLIA("EB", "Greater Anglia", "21", "LE", true, false),
  HEATHROW_CONNECT("EE", "Heathrow Connect", "24", "HC", true, false),
  HEATHROW_EXPRESS("HM", "Heathrow Express", "86", "HX", true, false),
  ISLAND_LINES("HZ", "Island Lines", "85", "IL", true, false),
  LOCOMOTIVE_SERVICES("LS", "Locomotive Services", "89", "LS", true, false),
  WEST_MIDLANDS_TRAINS("EJ", "West Midlands Trains", "29", "LM", true, false),
  LONDON_OVERGROUND("EK", "London Overground", "30", "LO", true, false),
  LUL_BAKERLOO_LINE("XC", "LUL Bakerloo Line", "91", "LT", true, false),
  LUL_DISTRICT_LINE_RICHMOND("XE", "LUL District Line - Richmond", "93", "LT", true, false),
  LUL_DISTRICT_LINE_WIMBLEDON("XB", "LUL District Line - Wimbledon", "90", "LT", true, false),
  MERSEYRAIL("HE", "Merseyrail", "64", "ME", true, false),
  NETWORK_RAIL_ON_TRACK_MACHINES("LR", "Network Rail (On-Track Machines)", "15", "LR", true, false),
  NEXUS_TYNE_AND_WEAR_METRO("PG", "Nexus (Tyne & Wear Metro)", "56", "TW", true, false),
  NORTH_YORKSHIRE_MOORS_RAILWAY("PR", "North Yorkshire Moors Railway", "51", "NY", true, false),
  SCOTRAIL("HA", "ScotRail", "60", "SR", true, false),
  SOUTH_WESTERN_RAILWAY("HY", "South Western Railway", "84", "SW", true, false),
  SOUTH_YORKSHIRE_SUPERTRAM("SJ", "South Yorkshire Supertram", "19", "SJ", true, false),
  SOUTHEASTERN("HU", "Southeastern", "80", "SE", true, false),
  SOUTHERN("HW", "Southern", "88", "SN", true, false),
  SWANAGE_RAILWAY("SP", "Swanage Railway", "18", "SP", true, false),
  ELIZABETH_LINE("EX", "Elizabeth line", "33", "XR", true, false),
  TRANSPENNINE_EXPRESS("EA", "TransPennine Express", "20", "TP", true, false),
  AVANTI_WEST_COAST("HF", "Avanti West Coast", "65", "VT", true, false),
  LONDON_NORTH_EASTERN_RAILWAY("HB", "London North Eastern Railway", "61", "GR", true, false),
  WEST_COAST_RAILWAYS("PA", "West Coast Railways", "50", "WR", true, false),
  JSD_RAIL_RESEARCH_AND_DEVELOPMENT("RR",
      "JSD Rail Research & Development",
      "02",
      "ZZ",
      true,
      false),
  VICTA_WESTLINK_RAIL_DEFUNCT("PV", "Victa Westlink Rail (defunct)", "03", "ZZ", true, true),
  DB_CARGO_CHARTERS("FM", "DB Cargo Charters", "04", "ZZ", true, false),
  DB_CARGO_FREIGHT("WA", "DB Cargo Freight", "05", "ZZ", true, false),
  RAIL_OPERATIONS_GROUP("PH", "Rail Operations Group", "07", "ZZ", true, false),
  DB_CARGO_INTERNATIONAL("DA", "DB Cargo International", "08", "ZZ", true, false),
  FREIGHTLINER_INTERMODAL("DB", "Freightliner Intermodal", "09", "ZZ", true, false),
  SERCO_RAIL_OPERATIONS("SD", "Serco Rail Operations", "10", "ZZ", true, false),
  FREIGHTLINER_HEAVY_HAUL("DH", "Freightliner Heavy Haul", "11", "ZZ", true, false),
  FREIGHT_EUROPE_DEFUNCT("PN", "Freight Europe (defunct)", "12", "ZZ", true, true),
  EUROPORTE_CHANNEL("PT", "Europorte Channel", "13", "ZZ", true, false),
  LORAM("LC", "LORAM", "16", "ZZ", true, false),
  HANSON_AND_HALL_RAIL_SERVICES("YG", "Hanson & Hall Rail Services", "17", "ZZ", true, false),
  NETWORK_RAIL_VIRTUAL_FREIGHT_COMPANY("QJ",
      "Network Rail Virtual Freight Company",
      "31",
      "ZZ",
      true,
      false),
  WREXHAM_AND_SHROPSHIRE_DEFUNCT("EI", "Wrexham and Shropshire (defunct)", "32", "WS", true, true),
  VINTAGE_TRAINS("TY", "Vintage Trains", "36", "TY", true, false),
  SECO_RAIL_DEFUNCT("RU", "Seco Rail (defunct)", "37", "ZZ", true, true),
  CARILLION_RAIL_CTRL_PHASE_1_DEFUNCT("RQ",
      "Carillion Rail CTRL (Phase 1) (defunct)",
      "38",
      "ZZ",
      true,
      true),
  HARSCO("RT", "Harsco", "39", "ZZ", true, false),
  BALFOUR_BEATTY_RAIL("RZ", "Balfour Beatty Rail", "40", "ZZ", true, false),
  UNMAPPED_41(null, "Unmapped", "41", null, false, false),
  COLAS_RAIL("RG", "Colas Rail", "42", "ZZ", true, false),
  AMEY_FLEET_SERVICES("RE", "Amey Fleet Services", "43", "ZZ", true, false),
  CARILLION_RAIL("RB", "Carillion Rail", "44", "ZZ", true, false),
  LUMO("LD", "Lumo", "45", "LD", true, false),
  SB_SWIETELSKY_BABCOCK_RAIL("RD", "SB (Swietelsky Babcock) Rail", "46", "ZZ", true, false),
  VOLKERRAIL("RH", "VolkerRail", "49", "ZZ", true, false),
  PRE_METRO_OPERATIONS("PK", "Pre Metro Operations", "52", "ZZ", true, false),
  SNCF_FREIGHT_SERVICES("PS", "SNCF Freight Services", "53", "ZZ", true, false),
  UNMAPPED_57(null, "Unmapped", "57", null, false, false),
  UNMAPPED_ADVENZA_FREIGHT("PI", "Unmapped (was Advenza Freight)", "58", "ZZ", false, false),
  ON_ROUTE_LOGISTICS("PM", "On Route Logistics", "59", "ZZ", true, false),
  SLC_OPERATIONS("SO", "SLC Operations", "11[3]", "SO", true, false),
  UNMAPPED_62(null, "Unmapped", "62", null, false, false),
  UNMAPPED_63(null, "Unmapped", "63", null, false, false),
  UNMAPPED_66(null, "Unmapped", "66", null, false, false),
  UNMAPPED_67(null, "Unmapped", "67", null, false, false),
  UNMAPPED_68(null, "Unmapped", "68", null, false, false),
  UNMAPPED_69(null, "Unmapped", "69", null, false, false),
  UNMAPPED_70(null, "Unmapped", "70", null, false, false),
  GRAND_UNION_TRAINS("LF", "Grand Union Trains", "12", "LF", true, false),
  LEGGE_INFRASTRUCTURE_SERVICES("LG", "Legge Infrastructure Services", "72", "ZZ", true, false),
  UNMAPPED_73(null, "Unmapped", "73", null, false, false),
  UNMAPPED_75(null, "Unmapped", "75", null, false, false),
  UNMAPPED_76(null, "Unmapped", "76", null, false, false),
  UNMAPPED_77(null, "Unmapped", "77", null, false, false),
  UNMAPPED_78(null, "Unmapped", "78", null, false, false),
  UNMAPPED_SOUTHERN(null, "Unmapped (was Southern)", "82", "SN", false, false),
  UNMAPPED_83(null, "Unmapped", "83", null, false, false),
  UNMAPPED_87(null, "Unmapped", "87", null, false, false),
  NETWORK_RAIL_RESERVED_PATHINGS_NON_QJ("NR",
      "Network Rail Reserved Pathings (non-QJ)",
      "92",
      "ZZ",
      true,
      false),
  FFESTINIOG_RAILWAY("XJ", "Ffestiniog Railway", "94", null, true, false),
  VARAMIS_RAIL("MV", "Varamis Rail", "95", null, true, false),
  UNMAPPED_96(null, "Unmapped", "96", null, false, false),
  DIRECT_RAIL_SERVICES("XH", "Direct Rail Services", "97", "ZZ", true, false),
  INTERNAL_TESTING("RM", "Internal Testing", "98", "ZZ", true, false),
  UNMAPPED_99(null, "Unmapped", "99", null, false, false),
  UNMAPPED_ANGLIA_RAILWAYS(null, "Unmapped (was Anglia Railways)", null, null, false, false),
  UNMAPPED_SILVERLINK_TRAIN_SERVICES(null,
      "Unmapped (was Silverlink Train Services)",
      null,
      null,
      false,
      false),
  UNMAPPED_CENTRAL_TRAINS(null, "Unmapped (was Central Trains)", null, null, false, false),
  UNMAPPED_WAGN(null, "Unmapped (was WAGN)", null, null, false, false),
  UNMAPPED_FIRST_GREAT_EASTERN(null,
      "Unmapped (was First Great Eastern)",
      null,
      null,
      false,
      false);

  private final String businessCode;
  private final String companyName;
  private final String sectorCode;
  private final String atocCode;
  private final boolean mapped;
  private final boolean defunct;

  Toc(String businessCode,
      String companyName,
      String sectorCode,
      String atocCode,
      boolean mapped,
      boolean defunct) {
    this.businessCode = businessCode;
    this.companyName = companyName;
    this.sectorCode = sectorCode;
    this.atocCode = atocCode;
    this.mapped = mapped;
    this.defunct = defunct;
  }

  public Optional<String> getBusinessCode() {
    return Optional.ofNullable(businessCode);
  }

  public String getCompanyName() {
    return companyName;
  }

  public Optional<String> getSectorCode() {
    return Optional.ofNullable(sectorCode);
  }

  public Optional<String> getAtocCode() {
    return Optional.ofNullable(atocCode);
  }

  public boolean isMapped() {
    return mapped;
  }

  public boolean isDefunct() {
    return defunct;
  }

  public Set<Toc> getAllNonDefunctMappedTocs() {
    return Stream
        .of(Toc.values())
        .filter(toc -> !toc.isDefunct() && toc.isMapped())
        .collect(Collectors.toSet());
  }

  @Override
  public String getLiteral() {
    return atocCode;
  }
}