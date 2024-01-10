package com.tenbeggar.pob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 游戏类型
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "game_type")
public class GameTypeEntity extends BaseEntity {

    /**
     * 游戏类型
     */
    @Column(unique = true)
    private String gametype;

    /**
     * 描述
     */
    private String description;
}
