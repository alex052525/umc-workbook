package umc.study.domain.member.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.mission.dto.MissionPreViewListByMemberDTO;

public interface MemberCommandService
{
    Member joinMember(MemberRequestDTO.JoinDto request);
    Member findMemberById(Long id);

    Page<MemberMission> findAllMissionByMember(Member member, PageRequest pageRequest);

    MissionPreViewListByMemberDTO getMissionList(Long memberId, Integer page);
}
