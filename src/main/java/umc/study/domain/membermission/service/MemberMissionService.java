package umc.study.domain.membermission.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.member.entity.Member;
import umc.study.domain.membermission.dto.MissionUpdatedReponseDTO;
import umc.study.domain.membermission.entity.MemberMission;

public interface MemberMissionService {
    MissionUpdatedReponseDTO updateStatusToChallenging(Long id);

    Page<MemberMission> findAllByMemberAndStatus(Member member, PageRequest pageRequest);

    MissionUpdatedReponseDTO updateStatusToComplete(Long memberId, Long missionId);
}
