package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ParticipantEntity;
import com.tenbeggar.pob.entity.ParticipantPerkEntity;
import com.tenbeggar.pob.enums.ParticipantPerkEnum;
import lombok.Data;

import java.util.List;

/**
 * 属性符文
 */
@Data
public class ParticipantPerkStat {

    private Integer defense;
    private Integer flex;
    private Integer offense;

    public List<ParticipantPerkEntity> toEntity(ParticipantEntity participantEntity) {
        String matchId = participantEntity.getMatchId();
        Integer participantId = participantEntity.getParticipantId();
        Integer championId = participantEntity.getChampionId();
        Boolean win = participantEntity.getWin();
        String gameVersion = participantEntity.getGameVersion();
        Long gameCreation = participantEntity.getGameCreation();
        Integer queueId = participantEntity.getQueueId();
        return List.of(ParticipantPerkEntity.builder()
                        .perkId(this.getDefense()).description(ParticipantPerkEnum.statDefense.name())
                        .matchId(matchId).participantId(participantId)
                        .championId(championId).win(win)
                        .gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ParticipantPerkEntity.builder()
                        .perkId(this.getFlex()).description(ParticipantPerkEnum.statFlex.name())
                        .matchId(matchId).participantId(participantId)
                        .championId(championId).win(win)
                        .gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ParticipantPerkEntity.builder()
                        .perkId(this.getOffense()).description(ParticipantPerkEnum.statOffense.name())
                        .matchId(matchId).participantId(participantId)
                        .championId(championId).win(win)
                        .gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build());
    }
}
