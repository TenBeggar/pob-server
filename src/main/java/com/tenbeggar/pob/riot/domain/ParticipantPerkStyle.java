package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ParticipantEntity;
import com.tenbeggar.pob.entity.ParticipantPerkEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 主系|副系 选择的符文
 */
@Data
public class ParticipantPerkStyle {

    private String description;//符文类型：primaryStyle.主系 subStyle.副系
    private Integer style;//主系第一个符文id
    private List<ParticipantPerkStyleSelection> selections;//选择的符文

    public List<ParticipantPerkEntity> toEntity(ParticipantEntity participantEntity) {
        return this.getSelections().stream().map(e -> ParticipantPerkEntity.builder()
                .perkId(e.getPerk()).description(this.getDescription())
                .matchId(participantEntity.getMatchId()).participantId(participantEntity.getParticipantId())
                .championId(participantEntity.getChampionId()).win(participantEntity.getWin())
                .gameVersion(participantEntity.getGameVersion()).gameCreation(participantEntity.getGameCreation()).queueId(participantEntity.getQueueId())
                .build()
        ).collect(Collectors.toList());
    }
}
