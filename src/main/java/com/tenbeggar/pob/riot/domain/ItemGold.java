package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 装备价格
 */
@Data
public class ItemGold {

    private Integer base;//售价或合成费用
    private Boolean purchasable;//是否可购买
    private Integer total;//总价格
    private Integer sell;//卖出价格
}
