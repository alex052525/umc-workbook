package umc.study.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.member.converter.MemberConverter;
import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.dto.MemberResponseDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.service.MemberCommandService;
import umc.study.domain.membermission.dto.MissionUpdatedReponseDTO;
import umc.study.domain.membermission.service.MemberMissionService;
import umc.study.domain.mission.dto.MissionPreViewListByMemberDTO;
import umc.study.global.apipayload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toResultDTO(member));
    }

    @PostMapping("/challenge/{missionId}")
    public ApiResponse<MissionUpdatedReponseDTO> challengeMission(@PathVariable Long missionId) {
        MissionUpdatedReponseDTO response = memberMissionService.updateStatusToChallenging(missionId);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{memberId}/missions")
    public ApiResponse<MissionPreViewListByMemberDTO> getMissions (@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page", defaultValue = "0") Integer page){
        MissionPreViewListByMemberDTO missions = memberCommandService.getMissionList(memberId,page);
        return ApiResponse.onSuccess(missions);
    }

    @PatchMapping("/complete/{memberId}/missions/{missionId}")
    public ApiResponse<MissionUpdatedReponseDTO> completeMission(@PathVariable(name = "memberId") Long memberId, @PathVariable(name = "missionId") Long missionId) {
        MissionUpdatedReponseDTO response = memberMissionService.updateStatusToComplete(memberId, missionId);
        return ApiResponse.onSuccess(response);
    }
}