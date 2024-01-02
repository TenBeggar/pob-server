package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.List;

@Data
public class PerkStyle {

    private String description;
    private Integer style;
    private List<PerkStyleSelection> selections;
}
