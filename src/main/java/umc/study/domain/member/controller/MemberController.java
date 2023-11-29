package umc.study.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.member.converter.MemberConverter;
import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.dto.MemberResponseDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.service.MemberCommandService;
import umc.study.global.apipayload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}