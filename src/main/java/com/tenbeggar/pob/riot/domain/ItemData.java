package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ItemData {

    private String type;//类型
    private String version;//版本
    private Item basic;//模板
    private Map<String, Item> data;//装备数据
    private List<?> groups;
    private List<?> tree;
}
