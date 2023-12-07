package umc.study.domain.membermission.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.membermission.dto.MissionUpdatedReponseDTO;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.mission.dto.MissionPreViewByMemberDTO;
import umc.study.domain.mission.dto.MissionPreViewListByMemberDTO;
import umc.study.domain.mission.entity.Mission;

import java.time.LocalDateTime;

@Component
public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder()
                .mission(mission)
                .build();
    }

    public static MissionUpdatedReponseDTO toMissionUpdatedReponseDTO(MemberMission memberMission) {
        return MissionUpdatedReponseDTO.builder()
                .missionId(memberMission.getMission().getId())
                .updateAt(LocalDateTime.now())
                .build();
    }
    public MissionPreViewByMemberDTO toMissionPreViewDTO(MemberMission memberMission) {
        return MissionPreViewByMemberDTO.builder()
            .memberName(memberMission.getMember().getName())
            .description(memberMission.getMission().getDescription())
            .reward(memberMission.getMission().getReward())
            .Status(memberMission.getMissionStatus())
            .createdAt(memberMission.getCreatedAt().toLocalDate())
            .build();
    }

    public MissionPreViewListByMemberDTO toMissionPreViewListDTO(Page<MemberMission> missionList) {
        List<MissionPreViewByMemberDTO> missionPreViewByMemberDTOList = missionList.stream()
            .map(this::toMissionPreViewDTO).collect(Collectors.toList());

        return MissionPreViewListByMemberDTO.builder()
            .isLast(missionList.isLast())
            .isFirst(missionList.isFirst())
            .totalPage(missionList.getTotalPages())
            .totalElements(missionList.getTotalElements())
            .listSize(missionPreViewByMemberDTOList.size())
            .missionList(missionPreViewByMemberDTOList)
            .build();
    }
}
