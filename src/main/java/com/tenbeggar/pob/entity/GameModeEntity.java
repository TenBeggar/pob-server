package com.tenbeggar.pob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 游戏模式
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "game_mode")
public class GameModeEntity extends BaseEntity {

    /**
     * 游戏模式
     */
    @Column(unique = true)
    private String gameMode;

    /**
     * 描述
     */
    private String description;
}
