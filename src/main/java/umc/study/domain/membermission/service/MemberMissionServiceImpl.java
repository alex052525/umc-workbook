package umc.study.domain.membermission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.entity.Member;
import umc.study.domain.membermission.converter.MemberMissionConverter;
import umc.study.domain.membermission.dto.MissionChallengeReponseDTO;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.membermission.repository.MemberMissionRepository;
import umc.study.domain.mission.enums.MissionStatus;
import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    @Override
    public MissionChallengeReponseDTO updateStatusToChallenging(Long id) {
        MissionStatus challengingStatus = MissionStatus.IN_PROGRESS;
        memberMissionRepository.updateMissionStatusByMissionId(id, challengingStatus);
        MemberMission updatedMemberMission =  memberMissionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND)
        );
        return MemberMissionConverter.toMissionChallengeReponseDTO(updatedMemberMission);
    }

    @Override
    public Page<MemberMission> findAllByMemberAndStatus(Member member, PageRequest pageRequest) {
        return memberMissionRepository.findAllByMemberAndMissionStatus(member, MissionStatus.IN_PROGRESS,pageRequest);
    }
}
