package umc.study.domain.membermission.service;

import umc.study.domain.membermission.dto.MissionChallengeReponseDTO;

public interface MemberMissionService {
    MissionChallengeReponseDTO updateStatusToChallenging(Long id);
}
