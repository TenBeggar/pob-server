package com.tenbeggar.pob.enums;

import com.tenbeggar.pob.controller.vo.ParticipantPerkVO;
import com.tenbeggar.pob.entity.ParticipantPerkEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 符文类型
 */
public enum ParticipantPerkEnum {

    /**
     * 主系
     */
    primaryStyle,

    /**
     * 副系
     */
    subStyle,

    statDefense,

    statFlex,

    statOffense,
    ;

    public static List<ParticipantPerkVO> toVO(List<ParticipantPerkEntity> participantPerkEntities) {
        List<ParticipantPerkVO> participantPerkVOS = new ArrayList<>();
        List<Integer> primaryPerk = new ArrayList<>();
        List<Integer> subPerk = new ArrayList<>();
        participantPerkEntities.forEach(e -> {
            switch (e.getDescription()) {
                case "statDefense" -> participantPerkVOS.add(ParticipantPerkVO.builder().description(statDefense.name()).perkId(List.of(e.getPerkId())).build());
                case "statFlex" -> participantPerkVOS.add(ParticipantPerkVO.builder().description(statFlex.name()).perkId(List.of(e.getPerkId())).build());
                case "statOffense" -> participantPerkVOS.add(ParticipantPerkVO.builder().description(statOffense.name()).perkId(List.of(e.getPerkId())).build());
                case "primaryStyle" -> primaryPerk.add(e.getPerkId());
                case "subStyle" -> subPerk.add(e.getPerkId());
            }
        });
        participantPerkVOS.add(ParticipantPerkVO.builder().description(primaryStyle.name()).perkId(primaryPerk).build());
        participantPerkVOS.add(ParticipantPerkVO.builder().description(subStyle.name()).perkId(subPerk).build());
        return participantPerkVOS;
    }
}
