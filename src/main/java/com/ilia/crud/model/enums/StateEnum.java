package com.ilia.crud.model.enums;

public enum StateEnum {
  RO(11, "RONDÔNIA"),
  AC(12, "ACRE"),
  AM(13, "AMAZONAS"),
  RR(14, "RORAIMA"),
  PA(15, "PARÁ"),
  AP(16, "AMAPÁ"),
  TO(17, "TOCANTINS"),
  MA(21, "MARANHÃO"),
  PI(22, "PIAUÍ"),
  CE(23, "CEARÁ"),
  RN(24, "RIO GRANDE DO NORTE"),
  PB(25, "PARAÍBA"),
  PE(26, "PERNAMBUCO"),
  AL(27, "ALAGOAS"),
  SE(28, "SERGIPE"),
  BA(29, "BAHIA"),
  MG(31, "MINAS GERAIS"),
  ES(32, "ESPÍRITO SANTO"),
  RJ(33, "RIO DE JANEIRO"),
  SP(35, "SÃO PAULO"),
  PR(41, "PARANÁ"),
  SC(42, "SANTA CATARINA"),
  RS(43, "RIO GRANDE DO SUL"),
  MS(50, "MATO GROSSO DO SUL"),
  MT(51, "MATO GROSSO"),
  GO(52, "GÓIAS"),
  DF(53, "DISTRITO FEDERAL");

  private final int code;
  private final String initials;

  StateEnum(int code, String initials) {
    this.code = code;
    this.initials = initials;
  }
}
