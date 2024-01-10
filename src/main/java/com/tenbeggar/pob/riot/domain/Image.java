package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 图片
 */
@Data
public class Image {

    private String full;//文件名
    private String sprite;
    private String group;//所属分类：champion.英雄 spell.技能 item.装备
    //位置
    private Integer x;
    private Integer y;
    private Integer w;
    private Integer h;
}
