package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ParticipantEntity;
import com.tenbeggar.pob.entity.ParticipantPerkEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 穿戴的符文
 */
@Data
public class ParticipantPerk {

    private ParticipantPerkStat statPerks;//属性符文

    private List<ParticipantPerkStyle> styles;//主系|副系 选择的符文

    public List<ParticipantPerkEntity> toEntity(ParticipantEntity participantEntity) {
        List<ParticipantPerkEntity> participantPerkEntities = new ArrayList<>();
        ParticipantPerkStat statPerk = this.getStatPerks();
        if (Objects.nonNull(statPerk)) {
            List<ParticipantPerkEntity> participantStatPerkEntities = statPerk.toEntity(participantEntity);
            participantPerkEntities.addAll(participantStatPerkEntities);
        }
        List<ParticipantPerkStyle> styles = this.getStyles();
        if (!CollectionUtils.isEmpty(styles)) {
            List<ParticipantPerkEntity> participantStylePerkEntities = this.getStyles().stream().map(e -> e.toEntity(participantEntity)).flatMap(List::stream).collect(Collectors.toList());
            participantPerkEntities.addAll(participantStylePerkEntities);
        }
        return participantPerkEntities;
    }
}
