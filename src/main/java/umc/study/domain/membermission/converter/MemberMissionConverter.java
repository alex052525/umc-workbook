package umc.study.domain.membermission.converter;

import umc.study.domain.membermission.dto.MissionChallengeReponseDTO;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.mission.entity.Mission;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder()
                .mission(mission)
                .build();
    }

    public static MissionChallengeReponseDTO toMissionChallengeReponseDTO(MemberMission memberMission) {
        return MissionChallengeReponseDTO.builder()
                .missionId(memberMission.getMission().getId())
                .updateAt(LocalDateTime.now())
                .build();
    }
}
