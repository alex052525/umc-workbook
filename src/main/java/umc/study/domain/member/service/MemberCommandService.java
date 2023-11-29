package umc.study.domain.member.service;

import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.entity.Member;

public interface MemberCommandService
{
    Member joinMember(MemberRequestDTO.JoinDto request);
}
