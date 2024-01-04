package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "history_version", uniqueConstraints = @UniqueConstraint(columnNames = {"version", "language"}))
public class HistoryVersionEntity extends BaseEntity {

    /**
     * 版本
     */
    private String version;

    /**
     * 支持的语言
     */
    private String language;
}
