package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.List;

@Data
public class Perk {

    private PerkStat statPerk;
    private List<PerkStyle> styles;
}
